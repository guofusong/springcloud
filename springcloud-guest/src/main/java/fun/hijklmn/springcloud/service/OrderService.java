package fun.hijklmn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.po.OrderDTO;
import fun.hijklmn.springcloud.service.impl.OrderServiceFeignFallback;

@FeignClient(value = "springcloud-biz-order", fallback = OrderServiceFeignFallback.class)
public interface OrderService {

	@RequestMapping(value = "/order/addOrder")
	Rsp addOrder(OrderDTO orderDTO);
	
}
