package net.frank.yangtes.commons.security.custom;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;

public class CustomPermissionAnnotationMethodInterceptor extends AuthorizingAnnotationMethodInterceptor {

	public CustomPermissionAnnotationMethodInterceptor(AuthorizingAnnotationHandler handler) {
		super(new CustomPermissionAnnotationHandler());
	}

	/**
	 *
	 * @param handler
	 * @param resolver
	 * @since 1.1
	 */
	public CustomPermissionAnnotationMethodInterceptor(AuthorizingAnnotationHandler handler,
			AnnotationResolver resolver) {
		super(new CustomPermissionAnnotationHandler(), resolver);
	}
	
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        assertAuthorized(methodInvocation);
        return methodInvocation.proceed();
    }

    /**
     * Ensures the calling Subject is authorized to execute the specified <code>MethodInvocation</code>.
     * <p/>
     * As this is an AnnotationMethodInterceptor, this implementation merely delegates to the internal
     * {@link AuthorizingAnnotationHandler AuthorizingAnnotationHandler} by first acquiring the annotation by
     * calling {@link #getAnnotation(MethodInvocation) getAnnotation(methodInvocation)} and then calls
     * {@link AuthorizingAnnotationHandler#assertAuthorized(java.lang.annotation.Annotation) handler.assertAuthorized(annotation)}.
     *
     * @param mi the <code>MethodInvocation</code> to check to see if it is allowed to proceed/execute.
     * @throws AuthorizationException if the method invocation is not allowed to continue/execute.
     */
    public void assertAuthorized(MethodInvocation mi) throws AuthorizationException {
        try {
            ((CustomPermissionAnnotationHandler)getHandler()).assertAuthorized(getAnnotation(mi));
        }
        catch(AuthorizationException ae) {
            // Annotation handler doesn't know why it was called, so add the information here if possible. 
            // Don't wrap the exception here since we don't want to mask the specific exception, such as 
            // UnauthenticatedException etc. 
            if (ae.getCause() == null) ae.initCause(new AuthorizationException("Not authorized to invoke method: " + mi.getMethod()));
            throw ae;
        }         
    }

	

}
