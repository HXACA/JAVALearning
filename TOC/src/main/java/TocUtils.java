import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import com.github.houbb.markdown.toc.vo.TocGen;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/8 19:54
 */
public class TocUtils {
    public static void main(String[] args) {
        TocGen tocGen = AtxMarkdownToc.newInstance().genTocFile("D:\\java\\JAVALearning\\README.md");
        System.out.println(tocGen);
    }
}
