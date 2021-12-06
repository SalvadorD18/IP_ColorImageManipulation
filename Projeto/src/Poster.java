class Poster {

	Layer[] collection;
	int width;
	int height;


	Poster(int width, int height){
		this.collection = new Layer [48];
		this.width = width;
		this.height = height;
	}

	//1.

	void setLayer(ColorImage img){
		img = ColorImageManipulation.background(img, this.width, this.height);
		Layer l = new Layer(img);
		this.collection[0] = l;
	}

	//2.

	void addLayer(Layer l){
		if(l == null)
			throw new NullPointerException("Não poderá ser adicionada uma Layer vazia.");
		for(int v = 0; v < collection.length; v++){
			if(collection[v] == null){
				collection[v] = l;
				return;
			}
		}
	}

	//3.

	void removeLayer(int pos){
		if(pos < 0)
			throw new IllegalStateException("A Layer da posição 0 não pode ser removida.");
		Layer[] aux = new Layer[this.collection.length];
		for(int i = 0; i < collection.length - 1; i++){
			if(i < pos)
				aux[i] = collection[i];
			else 
				aux[i] = collection[i+1];
		}
		collection = aux;
	}

	//4.

	void insertLayer(Layer l, int pos){
		if(l == null)
			throw new NullPointerException("Não poderá ser adicionada uma Layer vazia.");
		if(pos > collection.length)
			throw new IllegalArgumentException("A posição que escolheu para inserir a Layer ultrapassa o tamanho da coleção.");
		Layer[] aux = new Layer[this.collection.length];
		aux[pos] = l;
		for(int i = 0; i < collection.length - 1; i++){
			if(i < pos)
				aux[i] = collection[i];
			else 
				aux[i+1] = collection[i];
		}
		collection = aux;
	}

	//5.

	void swapPosition(int a, int b){
		if(a > collection.length || b > collection.length)
			throw new IllegalArgumentException("Um ou ambos os valores que inseriu ultrapassam o tamanho da coleção.");
		Layer[] aux = new Layer [1];
		aux[0] = collection[a];
		collection[a] = collection[b];
		collection[b] = aux[0];
	}

	//6.

	ColorImage finalPoster(){
		ColorImage fp = new ColorImage(width, height);
		for(int i = 0; collection[i] != null; i++){
			if(collection[i].getState()){
				ColorImage l = collection[i].getLayer();
				ColorImageManipulation.nonTransparent(l, fp, 0, 0);
				collection[i].getLayer();
			}
		}
		return fp;
	}


	static Poster testP(){
		Poster p = new Poster(680, 1000);
		ColorImage img = new ColorImage("Pineapple.png");
		ColorImage img2 = new ColorImage("SpongeBob.png");
		ColorImage img3 = new ColorImage("PatrickStar.png");
		ColorImage img4 = new ColorImage("Squidward.png");
		ColorImage img5 = new ColorImage("MrKrabs.png");
		ColorImage img6 = new ColorImage("SandyCheeks.png");
		ColorImage img7 = new ColorImage("Gary.png");
		ColorImage img8 = new ColorImage("Plankton.png");
		ColorImage img9 = new ColorImage("SpongeBobSquarePants.png");
		ColorImage img10 = new ColorImage("Nickelodeon.png");
		img10 = ColorImageManipulation.circle(img10, 100, 100, 100);
		Layer SpongeBob = new Layer(img2, 1.10, 30, 75, "SpongeBob");
		Layer PatrickStar = new Layer(img3, 1.30, 320, 15, "PatrickStar");
		Layer Squidward = new Layer(img4, 0.75, 288, 700, "Squidward");
		Layer MrKrabs = new Layer(img5, 0.9, 15, 653, "MrKrabs");
		Layer SandyCheeks = new Layer(img6, 0.7, 455, 700, "SandyCheeks");
		Layer Gary = new Layer(img7, 0.5, 35, 912, "Gary");
		Layer Plankton = new Layer(img8, 0.75, 282, 364, "Plankton");
		Layer Logo = new Layer(img9, 1, 95, 400, "Logo");
		Layer Nickelodeon = new Layer(img10, 0.4, 552, 558, "NickelodeonLogo");
		p.setLayer(img);
		p.addLayer(SpongeBob);
		p.addLayer(PatrickStar);
		p.addLayer(Squidward);
		p.addLayer(MrKrabs);
		p.addLayer(SandyCheeks);
		p.addLayer(Gary);
		p.addLayer(Plankton);
		p.addLayer(Logo);
		p.addLayer(Nickelodeon);
		//p.removeLayer(7);
		p.insertLayer(Logo, 8);
		p.swapPosition(1,2);
		ColorImage t = p.finalPoster();
		return p;
	}
	
	static Poster test(){
		Poster p = new Poster(500, 600);
		ColorImage img = new ColorImage("Background_Image2.png");
		p.setLayer(img);
		Layer l = new Layer(new ColorImage("CovidNews2.png"), 105, 220);
		p.addLayer(l);
		Layer l2 = new Layer(new ColorImage("CovidNews2.png"), 2, 0, 20, "CN2");
		p.addLayer(l2);
		ColorImage a = p.finalPoster();
		ColorImage img2 = new ColorImage("DonaldDuck2.png");
		img2 = ColorImageManipulation.circle(img2, 25, 25, 10);
		Layer l3 = new Layer(img2, 20, 0);
		p.addLayer(l3);
		ColorImage b = p.finalPoster();
		p.swapPosition(2, 3);
		ColorImage c = p.finalPoster();
		l2.setState(false);
		ColorImage d = p.finalPoster();
		p.removeLayer(1);
		l2.setState(true);
		ColorImage e = p.finalPoster();
		return p;
	}
		
		
		
		
		
		
		
		
		











}