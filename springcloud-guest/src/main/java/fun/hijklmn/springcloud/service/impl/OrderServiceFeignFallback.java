package fun.hijklmn.springcloud.service.impl;

import org.springframework.stereotype.Component;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.po.OrderDTO;
import fun.hijklmn.springcloud.service.OrderService;

@Component
public class OrderServiceFeignFallback implements OrderService{

	@Override
	public Rsp addOrder(OrderDTO orderDTO) {
		
		Rsp rsp = new Rsp();
		rsp.setCode(BizCode.fail.code());
		rsp.setResult("下单失败！");
		return rsp;
		
	}

}
