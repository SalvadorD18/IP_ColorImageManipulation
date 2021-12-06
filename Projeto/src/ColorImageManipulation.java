class ColorImageManipulation {

	//1.

	static Color Transparent = new Color (255, 255, 255);

	static void nonTransparent(ColorImage img, ColorImage img2, int x, int y){
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				if(i + x < img2.getWidth() && j + y < img2.getHeight()){
					if (!sameColor(img.getColor(i,j), Transparent)){
						img2.setColor(x + i, y + j, img.getColor(i,j));
					}
				}
			}
		}
	}

	static boolean sameColor(Color cimg, Color cimg2){
			return cimg.getR()==cimg2.getR() && cimg.getG()==cimg2.getG() && cimg.getB()==cimg2.getB();
	}

	static ColorImage test(){
		ColorImage img = new ColorImage("SpongeBob.png");
		ColorImage img2 = new ColorImage("Pineapple.png");
		nonTransparent(img, img2, 200, 200);
		return img2;
	}

	// 2.

	static ColorImage background(ColorImage pattern, int x, int y){
		ColorImage base = new ColorImage(x,y);
		for(int i = 0; i < base.getWidth(); i += pattern.getWidth()){
			for(int j = 0; j < base.getHeight(); j += pattern.getHeight()){
				pattern(pattern, base, i, j);
			}
		}
		return base;
	}

	static void pattern(ColorImage bg, ColorImage bg2, int xi, int yi){
		for(int i = 0; i < bg.getWidth(); i++){
			for(int j = 0; j < bg.getHeight(); j++){
				if(i + xi < bg2.getWidth() && j + yi < bg2.getHeight()){
					bg2.setColor(i + xi, j + yi, bg.getColor(i, j));
				}
			}
		}
	}

	static ColorImage test2(){
		ColorImage bg = new ColorImage("Pineapple.png");
		bg = background(bg, 600, 400);
		return bg;	
	}

	//3.
	static ColorImage scale(ColorImage img, double factor){
		if(factor < 0)
			throw new IllegalArgumentException("Não pode escolher um fator de escala negativo.");
		double w = img.getWidth()* factor;
		double h = img.getHeight()* factor;
		ColorImage scaled = new ColorImage((int)w,(int)h);
		for(int i = 0; i < scaled.getWidth(); i++){
			for(int j = 0; j < scaled.getHeight(); j++){
				scaled.setColor(i, j, img.getColor((int)(i/factor), (int)(j/factor)));
			}
		}
		return scaled;
	}

	static ColorImage test3(){
		ColorImage sImg = new ColorImage("SpongeBob.png");
		sImg = scale(sImg, 1.5);
		return sImg;
	}

	//4.
	
	static ColorImage circle(ColorImage img, int iCenter, int jCenter, int ray){
		if(iCenter < ray || jCenter < ray)
			throw new IllegalArgumentException("Os valores que escolhe não podem ser menores que o raio.");
		ColorImage cuttedImg = new ColorImage(ray*2, ray*2);
		for(int i = iCenter - ray; i < iCenter + ray; i++){
			for(int j = jCenter - ray; j < jCenter + ray; j++){
				cuttedImg.setColor(i - iCenter + ray, j - jCenter + ray, img.getColor(i, j));	
			}
		}
		for(int i = 0; i < cuttedImg.getWidth(); i++){
			for(int j = 0; j < cuttedImg.getHeight(); j++){
				int distance = (int)Math.sqrt(Math.pow(ray - i, 2) + Math.pow(ray - j, 2));
				if(distance > ray){
					cuttedImg.setColor(i, j, Transparent);
				}
			}
		}
		return cuttedImg;
	}

	static ColorImage test4(){
		ColorImage cImg = new ColorImage("PatrickStar.png");
		cImg = circle(cImg, 120, 100, 100);
		return cImg;
	}

	//5.
	static ColorImage grey(ColorImage img){
		for(int i = 0; i < img.getWidth(); i++){
			for(int j = 0; j < img.getHeight(); j++){
				img.setColor(i, j, img.getColor(i, j).grey());
			}
		}
		return img;
	}

	static ColorImage test5(){
		ColorImage gImg = new ColorImage("Squidward.png");
		gImg = grey(gImg);
		return gImg;
	}










}






