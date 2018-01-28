package com.example.restejbjpa.util;

import com.example.restejbjpa.domain.Studio;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class StudioResponse {
	
	private List<Studio> studio = new ArrayList<>();

	public List<Studio> getStudio() {
		return studio;
	}

	public void setStudio(List<Studio> studio) {
		this.studio = studio;
	}
}
