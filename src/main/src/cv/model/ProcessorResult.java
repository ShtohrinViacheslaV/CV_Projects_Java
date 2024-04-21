// ProcessorResult.java
package cv.model;

public class ProcessorResult {
    private final String url;
    private final boolean isForward;
    private final String includedPage;

    public ProcessorResult(String url, boolean isForward, String includedPage) {
        this.url = url;
        this.isForward = isForward;
        this.includedPage = includedPage;
    }

    public String getUrl() {
        return url;
    }

    public boolean isForward() {
        return isForward;
    }

    public String getIncludedPage() {
        return includedPage;
    }
}
