package rgcc.filter;



import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodingTool implements Filter {
    private String codeName = null;
    public void init(FilterConfig config) throws ServletException {
        //codeName = config.getInitParameter("codeName");
        //if (codeName == null) {
        //	codeName = "UTF-8";  // û�����ñ�������,Ĭ������ΪGBK
        //}
        codeName = "UTF-8";

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // �����ַ�����
        request.setCharacterEncoding(codeName);
        response.setCharacterEncoding(codeName);
        String a;

        // ��������
        chain.doFilter(request, response);
    }

    public void destroy() {

    }

    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
