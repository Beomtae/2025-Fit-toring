package fittoring.config.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasLoginMemberType = parameter.getParameterType().equals(LoginInfo.class);
        return hasLoginAnnotation && hasLoginMemberType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String requestAttributeName = "memberId";
        Object memberId = request.getAttribute(requestAttributeName);
        if (memberId == null) {
            throw new NullPointerException("memberId가 null 입니다."); //403 or 500 논의
            /*
            403: 개발자의 실수로 AuthRequired를 안붙인 것은 맞지만, 클라이언트의 입장에서는 인가가 필요한 상황인데 인가가 되지 않은 상황이므로 401
            500: 서버쪽에서 예상하지 못한 버그 같은 것들, 500으로 할거면 어떤 예외를 할지 고민
             */
        }
        return new LoginInfo((Long) memberId);
    }
}
