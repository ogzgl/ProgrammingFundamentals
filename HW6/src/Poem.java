
public class Poem {
	private String title;
	private int numberOfWords; //title is counted too;
	private int fileOrder;
	
	public Poem(){
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfWords() {
		return numberOfWords;
	}
	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}
	public int getFileOrder() {
		return fileOrder;
	}
	public void setFileOrder(int fileOrder) {
		this.fileOrder = fileOrder;
	}
	
}