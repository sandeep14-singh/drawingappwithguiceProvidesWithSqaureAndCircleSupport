package com.drawingapp.requests;

import javax.inject.Inject;

import com.drawingapp.annotations.Square;
import com.drawingapp.services.DrawShape;

public class SquareRequest {	
	DrawShape d;
	
	@Inject
	public SquareRequest(@Square DrawShape d){
		this.d = d;
	}
	public void makeRequest(){
		d.draw();
	}	
}
