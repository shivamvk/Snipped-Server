package io.snipped.rest.faq;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Faq {
	
	@Id
	ObjectId _id;
	String ques;
	String ans;
	
	public Faq(ObjectId _id, String ques, String ans) {
		this._id = _id;
		this.ques = ques;
		this.ans = ans;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

}
