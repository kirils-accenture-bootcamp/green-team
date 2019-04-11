package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ViewAllPollPage {
    //TODO rewrite so pollList consider pages
    private ArrayList<LinkedHashMap<String, String>> pollListOnPage;
    private final String[] pollValueNames = {"Title", "Status", "Votes", "Author", "Start Date", "End Date"};

    @FindBy(how = How.CLASS_NAME, using = "page-title-action")
    private WebElement addNewPollBtn;

    @FindBy(how = How.CLASS_NAME, using = "all")
    private WebElement filterLinkAll;
    @FindBy(how = How.CLASS_NAME, using = "publish")
    private WebElement filterLinkPublish;
    @FindBy(how = How.CSS, using = ".draft:nth-child(3)")
    private WebElement filterLinkDraft;
    @FindBy(how = How.CSS, using = ".draft:nth-child(4)")
    private WebElement filterLinkEndingSoon;
    @FindBy(how = How.CSS, using = ".draft:nth-child(5)")
    private WebElement filterLinkEnded;

    @FindBy(how = How.TAG_NAME, using = "poll-search-input")
    private WebElement pollSearchInput;
    @FindBy(how = How.TAG_NAME, using = "search-submit")
    private WebElement searchSubmitBtn;

    @FindBy(how = How.CLASS_NAME, using = "bulk-action-top")
    private WebElement bulkActionSelect;
    @FindBy(how = How.CSS, using = "input[value='Apply']")
    private WebElement applyBulkActionBtn;

    @FindBy(how = How.CSS, using = "input[name='perpage']")
    private WebElement itemsPerPageInput;
    @FindBy(how = How.XPATH, using = "//button[.='Set']")
    private WebElement setItemsPerPageBtn;

    @FindBy(how = How.XPATH, using = "//span[.='‹‹']")
    private WebElement firstPageBtn;
    @FindBy(how = How.XPATH, using = "//span[.='‹']")
    private WebElement previousPageBtn;
    @FindBy(how = How.XPATH, using = "//span[.='›']")
    private WebElement nextPageBtn;
    @FindBy(how = How.XPATH, using = "//span[.='››']")
    private WebElement lastPageBtn;
    @FindBy(how = How.ID, using = "current-poll-page-selector")
    private WebElement pageInput;

    @FindBy(how = How.ID, using = "cb-select-all-1")
    private WebElement selectAllCheckbox;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(2)")
    private WebElement titleColumn;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(4)")
    private WebElement statusColumn;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(6)")
    private WebElement votesColumn;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(7)")
    private WebElement authorColumn;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(8)")
    private WebElement startDateColumn;
    @FindBy(how = How.CSS, using = ".manage-column:nth-child(9)")
    private WebElement endDateColumn;

    @FindBy(how = How.CSS, using = "tbody > tr")
    private List<WebElement> polls;

    @FindBy(how = How.CSS, using = "input#yop-poll-shortcode")
    private WebElement pollCodeInput;
    @FindBy(how = How.CLASS_NAME, using = "close")
    private WebElement pollCodeCloseBtn;

    public void clickBtnByName(String name){
        switch (name){
            case "Add New":{
                clickAddNewBtn();
                break;
            }
            case "Search Polls":{
                clickSearchSubmitBtn();
                break;
            }
            case "Apply":{
                clickApplyBulkActionBtn();
                break;
            }
            case "Set":{
                clickSetItemsPerPageBtn();
                break;
            }
            case "<<":
            case "‹‹":{
                clickFirstPageBtn();
                break;
            }
            case "<":
            case "‹":{
                clickPreviousPageBtn();
                break;
            }
            case ">":
            case "›":{
                clickNextPageBtn();
                break;
            }
            case ">>":
            case "››":{
                clickLastPageBtn();
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid button name");
            }
        }
    }

    public void clickAddNewBtn(){
        addNewPollBtn.click();
    }

    public void clickFilterLinkByName(String name){
        switch (name){
            case "All":{
                clickAllFilerLink();
                break;
            }
            case "Published":{
                clickPublishedFilerLink();
                break;
            }
            case "Draft":{
                clickDraftFilerLink();
                break;
            }
            case "Ending Soon":{
                clickEndingSoonFilerLink();
                break;
            }
            case "Ended":{
                clickEndedFilerLink();
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid filter link name");
            }
        }
    }

    public void checkFilterCountByName(String name, int count){
        switch (name){
            case "All":{
                checkAllFilterCount(count);
                break;
            }
            case "Published":{
                checkPublishedFilterCount(count);
                break;
            }
            case "Draft":{
                checkDraftFilterCount(count);
                break;
            }
            case "Ending Soon":{
                checkEndingSoonFilterCount(count);
                break;
            }
            case "Ended":{
                checkEndedFilterCount(count);
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid filter link name");
            }
        }
    }

    public void clickAllFilerLink(){
        filterLinkAll.click();
    }

    public void checkAllFilterCount(int count){
        assertTrue(filterLinkAll.getText().contains("(" + count + ")"));
    }

    public void clickPublishedFilerLink(){
        filterLinkPublish.click();
    }

    public void checkPublishedFilterCount(int count){
        assertTrue(filterLinkPublish.getText().contains("(" + count + ")"));
    }

    public void clickDraftFilerLink(){
        filterLinkDraft.click();
    }

    public void checkDraftFilterCount(int count){
        assertTrue(filterLinkDraft.getText().contains("(" + count + ")"));
    }

    public void clickEndingSoonFilerLink(){
        filterLinkEndingSoon.click();
    }

    public void checkEndingSoonFilterCount(int count){
        assertTrue(filterLinkEndingSoon.getText().contains("(" + count + ")"));
    }

    public void clickEndedFilerLink(){
        filterLinkEnded.click();
    }

    public void checkEndedFilterCount(int count){
        assertTrue(filterLinkEnded.getText().contains("(" + count + ")"));
    }

    public void enterPollSearchInput(String input){
        pollSearchInput.clear();
        pollSearchInput.sendKeys(input);
    }

    public void pressEnterPollSearchInput(){
        pollSearchInput.sendKeys(Keys.ENTER);
    }

    public void clickSearchSubmitBtn(){
        searchSubmitBtn.click();
    }

    public void selectBulkActionSelect(String option){
        Select select = new Select(bulkActionSelect);
        switch (option){
            case "Bulk Actions":{
                select.selectByValue("-1");
                break;
            }
            case "Move to Trash":{
                select.selectByValue("trash");
                break;
            }
            case "Clone":{
                select.selectByValue("clone");
                break;
            }
            case "Reset Votes":{
                select.selectByValue("reset-votes");
                break;
            }
            default:{
                throw new InvalidArgumentException("invalid option: " + option);
            }
        }
    }

    public void clickApplyBulkActionBtn(){
        applyBulkActionBtn.click();
    }

    public void enterItemsPerPageField(String input){
        itemsPerPageInput.click();
        itemsPerPageInput.sendKeys(input);
    }

    public void clickSetItemsPerPageBtn(){
        setItemsPerPageBtn.click();
    }

    public void clickFirstPageBtn(){
        firstPageBtn.click();
    }

    public void clickPreviousPageBtn(){
        previousPageBtn.click();
    }

    public void clickNextPageBtn(){
        nextPageBtn.click();
    }

    public void clickLastPageBtn(){
        lastPageBtn.click();
    }

    public void enterPageInput(String input){
        pageInput.clear();
        pageInput.sendKeys(input);
    }

    public void checkPageInput(String pageNumber){
        assertEquals(pageNumber, pageInput.getAttribute("value"));
    }

    public void clickColumnByName(String name){
        switch (name){
            case "Title":{
                clickTitleColumn();
                break;
            }
            case "Status":{
                clickStatusColumn();
                break;
            }
            case "Votes":{
                clickVotesColumn();
                break;
            }
            case "Author":{
                clickAuthorColumn();
                break;
            }
            case "Start Date":{
                clickStartDateColumn();
                break;
            }
            case "End Date":{
                clickEndDateColumn();
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid column name");
            }
        }
    }

    public void clickTitleColumn(){
        titleColumn.click();
    }

    public void clickStatusColumn(){
        statusColumn.click();
    }

    public void clickVotesColumn(){
        votesColumn.click();
    }

    public void clickAuthorColumn(){
        authorColumn.click();
    }

    public void clickStartDateColumn(){
        startDateColumn.click();
    }

    public void clickEndDateColumn(){
        endDateColumn.click();
    }

    public void clickSelectAllPollsCheckbox(){
        selectAllCheckbox.click();
    }

    public void selectMultiplePolls(String indexes, boolean select){
        if (indexes.isEmpty()){
            return;
        }

        String[] indexArr = indexes.split(", ");

        for (String index: indexArr) {
            selectPoll(Integer.parseInt(index), select);
        }
    }

    public void selectPoll(int index, boolean select){
        if (select){
            if (!polls.get(index).findElement(By.cssSelector("input[type='checkbox']")).isSelected()){
                polls.get(index).findElement(By.cssSelector("input[type='checkbox']")).click();
            }
        } else {
            if (polls.get(index).findElement(By.cssSelector("input[type='checkbox']")).isSelected()){
                polls.get(index).findElement(By.cssSelector("input[type='checkbox']")).click();
            }
        }
    }

    public void checkPollTitle(String title, int index){
        assertEquals(title, getPollTitle(index));
    }

    public void clickPollTitle(int index){
        polls.get(index).findElement(By.cssSelector("a[title='Poll name']")).click();
    }

    public void clickPollResults(int index){
        polls.get(index).findElement(By.cssSelector("a[title='View Results']")).click();
    }

    public void checkPollStatus(String status, int index){
        assertEquals(status, getPollStatus(index));
    }

    public void clickPollCode(int index){
        polls.get(index).findElement(By.cssSelector("td:nth-child(5) i")).click();
    }

    public String getPollCode(){
        return pollCodeInput.getAttribute("value");
    }

    public String getPollCode(int index){
        clickPollCode(index);
        return getPollCode();
    }

    public void checkPollCode(String code){
        assertEquals(code, pollCodeInput.getAttribute("value"));
    }

    public void checkPollCode(String code, int index){
        clickPollCode(index);
        checkPollCode(code);
    }

    public void clickClosePollCodeWindow(){
        pollCodeCloseBtn.click();
    }

    public void checkPollVotes(String votesCount, int index){
        assertEquals(votesCount, getPollVotes(index));
    }

    public void checkAuthor(String author, int index){
        assertEquals(author, getPollAuthor(index));
    }

    public void checkStartDate(String date, int index){
        assertEquals(date, getPollStartDate(index));
    }

    public void checkEndDate(String date, int index){
        assertEquals(date, getPollEndDate(index));
    }

    public void hoverOverPoll(int index, Actions actions){
        actions.moveToElement(polls.get(index)).perform();
    }

    public void hoverClickByPollLinkName(String name, int index, Actions actions){
        switch (name){
            case "Edit":{
                hoverClickEditPoll(index, actions);
            }
            case "Trash":{
                hoverClickTrashPoll(index, actions);
            }
            case "Clone":{
                hoverClickClonePoll(index, actions);
            }
            default:{
                throw new InvalidArgumentException("Invalid link name");
            }
        }
    }

    public void hoverClickEditPoll(int index, Actions actions){
        hoverOverPoll(index, actions);
        polls.get(index).findElement(By.cssSelector(".edit > a")).click();
    }

    public void hoverClickTrashPoll(int index, Actions actions){
        hoverOverPoll(index, actions);
        polls.get(index).findElement(By.cssSelector(".trash > a")).click();
    }

    public void hoverClickClonePoll(int index, Actions actions){
        hoverOverPoll(index, actions);
        polls.get(index).findElement(By.cssSelector(".view > a")).click();
    }

    public String getPollValueByName(String name, int index){
        switch (name){
            case "Title":{
                return getPollTitle(index);
            }
            case "Status":{
                return getPollStatus(index);
            }
            case "Votes":{
                return getPollVotes(index);
            }
            case "Author":{
                return getPollAuthor(index);
            }
            case "Start Date":{
                return getPollStartDate(index);
            }
            case "End Date":{
                return getPollEndDate(index);
            }
            default:{
                throw new InvalidArgumentException("Invalid name");
            }
        }
    }

    public String getPollTitle(int index){
        return polls.get(index).findElement(By.cssSelector("a[title='Poll name']")).getText().replaceAll("\\s","");
    }

    public String getPollStatus(int index){
        return polls.get(index).findElement(By.cssSelector("td > label")).getText().replaceAll("\\s","");
    }

    public String getPollVotes(int index){
        return polls.get(index).findElement(By.cssSelector("td:nth-child(6)")).getText().replaceAll("\\s","");
    }

    public String getPollAuthor(int index){
        return polls.get(index).findElement(By.cssSelector("td:nth-child(7)")).getText().replaceAll("\\s","");
    }

    public String getPollStartDate(int index){
        return polls.get(index).findElement(By.cssSelector("td:nth-child(8)")).getText().replaceAll("\\s","");
    }

    public String getPollEndDate(int index){
        return polls.get(index).findElement(By.cssSelector("td:nth-child(9)")).getText().replaceAll("\\s","");
    }

    public void rememberCurrentPollListOnPage() {
        pollListOnPage = new ArrayList<>();
        for (int i = 0; i < polls.size(); i++) {
            pollListOnPage.add(new LinkedHashMap<>());
            for (String valueName: pollValueNames) {
                pollListOnPage.get(i).put(valueName, getPollValueByName(valueName, i));
            }
        }
    }

    public void checkPollSortedOnPage(String columnName, String order){
        boolean ascending;
        switch (order){
            case "ascending":{
                ascending = true;
                break;
            }
            case "descending":{
                ascending = false;
                break;
            }
            default:{
                throw new InvalidArgumentException("Invalid order");
            }
        }
        checkPollSortedOnPage(columnName, ascending);
    }

    public void checkPollSortedOnPage(String columnName, boolean ascending) {
        ArrayList<LinkedHashMap<String, String>> arr = getPollListOnPageCopy();

        Collections.sort(arr, new PollsComparator(columnName, ascending));

        checkComparePollListOnPage(arr);
    }

    public void checkComparePollListOnPage(ArrayList<LinkedHashMap<String, String>> arr){
        assertEquals(arr.size(), pollListOnPage.size());
        for (int i = 0; i < arr.size(); i++) {
            for (String k: arr.get(i).keySet()) {
                assertEquals(arr.get(i).get(k), pollListOnPage.get(i).get(k));
            }
        }
    }

    public ArrayList<LinkedHashMap<String, String>> getPollListOnPageCopy(){
        ArrayList<LinkedHashMap<String, String>> arr = new ArrayList<>();
        for (LinkedHashMap<String, String> map: pollListOnPage) {
            arr.add(new LinkedHashMap<>());
            map.forEach((k, v)->arr.get(arr.size() - 1).put(k, v));
        }
        return arr;
    }

    private class PollsComparator implements Comparator<LinkedHashMap<String, String>> {
        private String compareBy;
        private boolean ascending;

        public PollsComparator(String compareBy, boolean ascending) {
            this.compareBy = compareBy;
            this.ascending = ascending;
        }

        @Override
        public int compare(LinkedHashMap<String, String> p1, LinkedHashMap<String, String> p2) {
            if (ascending){
                return p1.get(compareBy).compareToIgnoreCase(p2.get(compareBy));
            } else {
                return -p1.get(compareBy).compareToIgnoreCase(p2.get(compareBy));
            }
        }
    }
}