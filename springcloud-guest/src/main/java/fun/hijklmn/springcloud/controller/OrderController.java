package fun.hijklmn.springcloud.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.constants.PayType;
import fun.hijklmn.springcloud.po.OrderDTO;
import fun.hijklmn.springcloud.po.RepoDTO;

import fun.hijklmn.springcloud.service.OrderService;
import fun.hijklmn.springcloud.service.RepoService;

@RestController
public class OrderController {

	@Resource
	OrderService orderService;
	
	@Resource
	RepoService repoService;
	
	@RequestMapping(value = "/addOrder")
	@HystrixCommand(fallbackMethod = "addOrderFallback")
	public Rsp addOrder() {

		final OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setAmount(20000L);
		orderDTO.setCreateDate(new Date());
		orderDTO.setGoodsName("西瓜");
		orderDTO.setNonStr(UUID.randomUUID().toString().replaceAll("-", ""));
		orderDTO.setNumber(2);
		orderDTO.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
		orderDTO.setPayType(PayType.WXPAY.code());
		
		Rsp orderRsp = orderService.addOrder(orderDTO);
		
		Rsp rsp = new Rsp();
		
		if (orderRsp == null || orderRsp.getCode() == BizCode.fail.code().intValue()) {
			rsp.setCode(orderRsp.getCode());
			rsp.setResult(orderRsp.getResult());
			return rsp;
		}
		
		final RepoDTO repoDTO = new RepoDTO();
		repoDTO.setAddress("重庆");
		repoDTO.setComment("小心轻放");
		repoDTO.setGoodsName(orderDTO.getGoodsName());
		repoDTO.setNumber(orderDTO.getNumber());
		repoDTO.setOrderId(orderDTO.getOrderId());
		
		Rsp repoRsp = repoService.delivery(repoDTO);
		
		rsp.setCode(orderRsp.getCode() == repoRsp.getCode() && repoRsp.getCode() == 1 ? 1 : 0);
		rsp.setResult(orderRsp.getResult() + repoRsp.getResult());
		
		return rsp;
		
	}
	
	public Rsp addOrderFallback() {
		
		Rsp rsp = new Rsp();
		rsp.setCode(BizCode.fail.code());
		rsp.setResult("下单失败！");
		return rsp;
		
	}
	
}
