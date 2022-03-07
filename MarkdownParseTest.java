import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void getLinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(content));

    }

    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet1() throws IOException {
        Path fileName = Path.of("snippet-1.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("google.com", "google.com", "ucsd.edu"), MarkdownParse.getLinks(content));
    }

    @Test
    public void snippet2() throws IOException {
        Path fileName = Path.of("snippet-2.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(content));
    }

    @Test
    public void snippet3() throws IOException {
        Path fileName = Path.of("snippet-3.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"),
                MarkdownParse.getLinks(content));
    }

}
