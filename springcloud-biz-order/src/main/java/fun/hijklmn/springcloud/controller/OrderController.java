package fun.hijklmn.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.po.OrderDTO;

@RestController
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value = "/order/addOrder")
	public Rsp addOrder(@RequestBody OrderDTO orderDTO) {
		
		logger.info("---------->addOrder: 订单号[{}], 商品名称[{}], 商品数量[{}]请求交易！", orderDTO.getOrderId(), orderDTO.getGoodsName(), orderDTO.getNumber());
		
		final Rsp rsp = new Rsp();
		
		rsp.setCode(BizCode.success.code());
		
		rsp.setResult("订单号[" + orderDTO.getOrderId() + "]商品名称[" + orderDTO.getGoodsName() + "]下单成功！");
		
		return rsp;
		
	}
	
	@RequestMapping(value = "/order/info")
	public Rsp info() {

		logger.info("----------->info:订单信息");

		final Rsp rsp = new Rsp();
		rsp.setCode(BizCode.success.code());
		rsp.setResult("Order Service");
		
		return rsp;
		
	}
	
}
