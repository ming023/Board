import java.io.IOException;
import java.security.AuthProvider;

import javax.security.sasl.AuthorizeCallback;

import com.apple.boardback.provider.JwtProvider;

@Component
@RequiredArgsContructor
public class JWtAuthenticationFilter  extends OnceperRequestFilter{

    private final JwtProvider JwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest, HttpServletResponse)
            throws ServletException, IOException {
        
        try {
            String token = parseBearerToken(request);

            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }
    
            String email = JwtProvider.validate(token);
    
            if (email == null) {
                filterChain.doFilter(request, response)
                return;
            }
    
            AbstractAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(email, credentials:null, AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
            SecurityContext SecurityContext = SecurityContextHolder.createEmpty()
            SecurityContext.setAuthentication(authenticationToken);

            SecurityContextHolder.setContext(securityContext);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }



private String parseBearerToken(HttpServletRequest request) {

    String authorization = request.getHeader(name:"Authorization");

    boolean hasAuthorization = StringUtils.hasText(authorization);
    if (!hasAuthorization) return null;

    boolean isBearer = authorization.startsWith("Bearer");
    if (!Bearer) return null;

    String token = authorization.substring(7);
    return token;
}