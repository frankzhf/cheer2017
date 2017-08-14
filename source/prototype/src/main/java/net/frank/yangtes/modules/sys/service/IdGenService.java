package net.frank.yangtes.modules.sys.service;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import net.frank.yangtes.commons.utils.IdGenUtil;

@Service("idGenService")
@Lazy(false)
public class IdGenService implements SessionIdGenerator {
	
	@Override
	public Serializable generateId(Session arg0) {
		return IdGenUtil.uuid();
	}
	
}
