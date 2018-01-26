package com.datayes.framework.mongo;

import org.springframework.data.annotation.Id;

public class MongoDemoModel {

    @Id
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return String.format("MongoDemoModel [id=%s]", id);
    }

}
