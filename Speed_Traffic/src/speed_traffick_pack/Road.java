package speed_traffick_pack;


public class Road {
    private Place start;
    private Place end;
    private int direction;
    // 0: North, 1:South, 2:east, 3:west

    public Road(Place start, Place end, int direction) {
        this.start = start;
        this.end = end;
        this.direction = direction;
    }
    // Nuevo constructor para cuando recien se crea la clase. 
    // No pide el end ni el start sino que los inicializa 
    public Road(int direction) {
        //this.start = new Place(false);
        this.end = this.start = null;
        this.direction = direction;
    }

    public Place getStart() {
        return start;
    }

    public Place getEnd() {
        return end;
    }

    public int getDirection() {
        return direction;
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public void setEnd(Place end) {
        this.end = end;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    // Cambie la funcion para que en lugar de recibir un place de entrada lo cree
    // Ademas lo puse como void porque no estaba retornando nada
    // Por ultimo hice que modificara la direccion
    public void addPlace(){
    	Place p = new Place(false);
    	if(this.end == null) {
    		this.start = this.end = p;
    	}else {
	        switch(this.direction){
	            case 0:
	                this.end.setNorth(p);
	                p.south = this.end;
	                this.end = p;
	                this.end.north = null;
	                break;
	            case 1:
	                this.end.setSouth(p);
	                p.north = this.end;
	                this.end = p;
	                this.end.south = null;
	                break;
	            case 2:
	                this.end.setEast(p);
	                p.west = this.end;
	                this.end = p;
	                this.end.east = null;
	                break;
	            case 3:
	                this.end.setWest(p);
	                p.east = this.end;
	                this.end = p;
	                this.end.west = null;
	                break;
	        }
        }
    }
    public void addPlace(Place p){
        switch(this.direction){
            case 0:
                this.end.setNorth(p);
                p.south = this.end;
                this.end = p;
                this.end.north = null;
                break;
            case 1:
                this.end.setSouth(p);
                p.north = this.end;
                this.end = p;
                this.end.south = null;
                break;
            case 2:
                this.end.setEast(p);
                p.west = this.end;
                this.end = p;
                this.end.east = null;
                break;
            case 3:
                this.end.setWest(p);
                p.east = this.end;
                this.end = p;
                this.end.west = null;
                break;
        }
    }

    public void removePlace(Place p){
        Place place =  this.start;
        while(place != p && place != null){
            switch(this.direction){
            case 0:
                place = place.getNorth();
                break;
            case 1:
                place = place.getSouth();
                break;
            case 2:
                place = place.getEast();
                break;
            case 3:
                place = place.getWest();
                break;
            }
        }
        
    }
    
    public void createRoad(Place intersection1, Place intersection2, int index1, int size) {
		for(int i=0; i<size; i++) {
			if (i==index1) {
				this.addPlace(intersection1);
				//System.out.println(intersection);
			}
			else if(i == index1 +1){
				this.addPlace(intersection2);
			}
			else{
				this.addPlace();
			}
		}
    }
    
    
    public void createRoad(Place intersection, int index, int size) {
		for(int i=0; i<size; i++) {
			if (i==index) {
				this.addPlace(intersection);
				//System.out.println(intersection);
			}
			else {
				this.addPlace();
			}
		}
    }
    
    
    public Place createRoad(int index, int size) {
    	Place aux=null;
		for(int i=0; i<size; i++) {
			this.addPlace();
			if (i==index) {
				aux = this.getEnd();
			}
		}
		return aux;
    }
    
    public void createRoad(int size) {
    	for(int i=0; i<size;i++) {
    		this.addPlace();
    	}
    }
}
