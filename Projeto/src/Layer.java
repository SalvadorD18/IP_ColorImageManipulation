class Layer {
	ColorImage img;
	double factor;
	int x;
	int y;
	String name;
	boolean active = false;


	//i) 

	Layer(ColorImage img, double factor, int x, int y, String name){
		this.img = img;
		this.factor = factor;
		this.x = x;
		this.y = y;
		this.name = name;
		this.active = true;
	}

	//ii)

	Layer(ColorImage img, int x, int y){
		this.img = img;
		this.factor = 1;
		this.x = x;
		this.y = y;
		String name = null;
		this.active = true;
	}

	//iii)

	Layer(ColorImage img){
		this.img = img;
		this.factor = 1;
		this.x = 0;
		this.y = 0;
		this.active = true;
	}

	//1.

	void setName(String name){
		this.name = name;
	}

	//2.

	void setScale(double factor){
		this.factor = factor;
	}

	void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	//3.

	void setState(boolean active){
		this.active = active;
	}

	boolean getState(){
		return active;
	}

	//4.

	ColorImage getLayer(){
		ColorImage scaled = ColorImageManipulation.scale(img, factor); 
		ColorImage bg = new ColorImage(x + scaled.getWidth(), y + scaled.getHeight());
		for(int i = 0; i < bg.getWidth(); i++){
			for(int j = 0; j < bg.getHeight(); j++){
				bg.setColor(i, j, ColorImageManipulation.Transparent);
			}
		}
		ColorImageManipulation.nonTransparent(scaled, bg, this.x, this.y);
		return bg;
	}


	static ColorImage test4(){
		ColorImage img = new ColorImage("SpongeBob.png");
		Layer o = new Layer(img);
		img = o.getLayer();
		return img;
	}
}
























