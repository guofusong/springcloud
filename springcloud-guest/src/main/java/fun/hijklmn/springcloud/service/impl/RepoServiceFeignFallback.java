package fun.hijklmn.springcloud.service.impl;

import org.springframework.stereotype.Component;

import fun.hijklmn.springcloud.biz.Rsp;
import fun.hijklmn.springcloud.constants.BizCode;
import fun.hijklmn.springcloud.po.RepoDTO;
import fun.hijklmn.springcloud.service.RepoService;

@Component
public class RepoServiceFeignFallback implements RepoService {

	@Override
	public Rsp delivery(RepoDTO repoDTO) {
		Rsp rsp = new Rsp();
		rsp.setCode(BizCode.fail.code());
		rsp.setResult("出货失败！");
		return rsp;
	}

}
