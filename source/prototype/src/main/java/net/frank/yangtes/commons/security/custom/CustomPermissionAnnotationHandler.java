package net.frank.yangtes.commons.security.custom;

import java.lang.annotation.Annotation;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.PermissionAnnotationHandler;

public class CustomPermissionAnnotationHandler extends PermissionAnnotationHandler {

	public void assertAuthorized(Annotation a) throws AuthorizationException {		
		/* TODO 
		String channelId = (String)UserUtils.getSession().getAttribute
				(com.laolian.goldsteward.backend.session.Constants.ADM_CHANNEL_ID_KEY);
		if(StringUtils.isNotBlank(channelId)){
			return;
		}
		**/
		super.assertAuthorized(a);	
    }
}
