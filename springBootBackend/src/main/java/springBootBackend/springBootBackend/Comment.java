package springBootBackend.springBootBackend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class Comment {
	@Id
	private String id;
	private String massage;
	
	public String getId() {
		return id;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}