package fun.hijklmn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.po.RepoDTO;
import fun.hijklmn.springcloud.service.impl.RepoServiceFeignFallback;

@FeignClient(value = "springcloud-biz-repo", fallback = RepoServiceFeignFallback.class)
public interface RepoService {

	@RequestMapping(value = "/repo/delivery")
	Rsp delivery(RepoDTO repoDTO);
	
}
