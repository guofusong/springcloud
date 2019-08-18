package fun.hijklmn.springcloud.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.po.RepoDTO;
import fun.hijklmn.springcloud.service.RepoService;

@RestController
public class RepoController {

	@Resource
	RepoService repoService;
	
	@RequestMapping(value = "/delivery")
	@HystrixCommand(fallbackMethod = "deliveryFallback")
	public Rsp delivery() {
		
		final RepoDTO repoDTO = new RepoDTO();
		repoDTO.setAddress("重庆市");
		repoDTO.setComment("小心轻放");
		repoDTO.setGoodsName("西瓜");
		repoDTO.setNumber(2);
		repoDTO.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
		
		return repoService.delivery(repoDTO);
		
	}
	
	public Rsp deliveryFallback() {
		
		final Rsp rsp = new Rsp();
		rsp.setCode(BizCode.fail.code());
		rsp.setResult("发货失败！");
		return rsp;
		
	}
	
}
