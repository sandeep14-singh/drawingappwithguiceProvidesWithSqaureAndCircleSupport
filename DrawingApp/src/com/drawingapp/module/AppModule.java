package com.drawingapp.module;

import com.drawingapp.annotations.Circle;
import com.drawingapp.annotations.CircleColorValue;
import com.drawingapp.annotations.SquareColorValue;
import com.drawingapp.annotations.EdgeSize;
import com.drawingapp.annotations.Radius;
import com.drawingapp.annotations.Square;
import com.drawingapp.services.DrawCircle;
import com.drawingapp.services.DrawShape;
import com.drawingapp.services.DrawSquare;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;


public class AppModule extends AbstractModule{
	
	@Override
	protected void configure() {
		//bind(DrawShape.class).to(DrawSquare.class);		
		bind(String.class).annotatedWith(SquareColorValue.class).toInstance("Red");
		bind(Integer.class).annotatedWith(EdgeSize.class).toInstance(40);
		
		bind(String.class).annotatedWith(CircleColorValue.class).toInstance("Black");
		bind(Integer.class).annotatedWith(Radius.class).toInstance(10);
	}
	
	@Provides	
	@Singleton
	@Square
	DrawShape providesDrawSquare(@SquareColorValue String color, @EdgeSize Integer edge){
		DrawShape d = new DrawSquare(color, edge);
		return d;
	}
	
	@Provides	
	@Singleton
	@Circle
	DrawShape providesDrawCircle(@CircleColorValue String color, @Radius Integer radius){
		DrawShape d = new DrawCircle(color, radius);
		return d;
	}
	
	
	
}
