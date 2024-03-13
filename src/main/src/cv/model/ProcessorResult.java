package cv.model;

public class ProcessorResult {
    private String url;
    private boolean isForward;
    private String includedPage;


    public ProcessorResult(String url, boolean isForward, String includedPage) {
        this.url = url;
        this.isForward = isForward;
        this.includedPage = includedPage;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isForward() {
        return isForward;
    }

    public void setForward(boolean forward) {
        isForward = forward;
    }

    public String getIncludedPage() {
        return includedPage;
    }

    public void setIncludedPage(String includedPage) {
        this.includedPage = includedPage;
    }
}
