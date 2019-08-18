package fun.hijklmn.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.po.RepoDTO;

@RestController
public class RepoController {
	
	private final Logger logger = LoggerFactory.getLogger(RepoController.class);

	@RequestMapping(value = "/repo/delivery")
	public Rsp delivery(@RequestBody RepoDTO repoDTO) {
		
		logger.info("---------->dilivery: 订单号[{}], 商品名称[{}], 商品数量[{}], 收货地址[{}], 请求发货！", repoDTO.getOrderId(), repoDTO.getGoodsName(), repoDTO.getNumber(), repoDTO.getAddress());
		
		final Rsp rsp = new Rsp();
		
		rsp.setCode(BizCode.success.code());
		
		rsp.setResult("订单号[" + repoDTO.getOrderId() + "]商品名称[" + repoDTO.getGoodsName() + "]收货地址[" + repoDTO.getAddress() + "]发货完成！");
		
		return rsp;
		
	}
	
	@RequestMapping(value = "/repo/info")
	public Rsp info() {
		
		final Rsp rsp = new Rsp();
		
		rsp.setCode(BizCode.success.code());
		rsp.setResult("Repo Service");
		
		return rsp;
		
	}
	
}
