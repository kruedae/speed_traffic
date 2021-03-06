package speed_traffick_pack;


public class Place {
    Place north;
    Place south;
    Place east;
    Place west;
    boolean blocked, measuring;
    int grid_x, grid_y, contCarros;

    public Place(boolean blocked, int grid_x, int grid_y) {
        this.blocked = blocked;
        this.grid_x = grid_x;
        this.grid_y = grid_y;
    }
    // Nuevo constructor para crear places sin grids mientras no los necesitemos
    
    public Place(boolean blocked) {
        this.blocked = blocked;
    }

    public Place getNorth() {
        return north;
    }

    public Place getSouth() {
        return south;
    }

    public Place getEast() {
        return east;
    }

    public Place getWest() {
        return west;
    }

    public boolean isBlocked() {
        return blocked;
    }
    
        public boolean isMeasuring() {
        return measuring;
    }

    public int getGrid_x() {
        return grid_x;
    }

    public int getGrid_y() {
        return grid_y;
    }

        public int getContCarros() {
        return contCarros;
    }
        
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

        public void setMeasuring(boolean medidor) {
        this.measuring = medidor;
    }
        
    public void setGrid_x(int grid_x) {
        this.grid_x = grid_x;
    }

    public void setGrid_y(int grid_y) {
        this.grid_y = grid_y;
    }

    public void setNorth(Place north) {
        this.north = north;
    }

    public void setSouth(Place south) {
        this.south = south;
    }

    public void setEast(Place east) {
        this.east = east;
    }

    public void setWest(Place west) {
        this.west = west;
    }
    
    public void setContCarros(int contCarros) {
        this.contCarros = contCarros;
    }
    
	public boolean FreeToMove(int a) {
		boolean state_nextplace = true;
		if(a == 0) {
			if (this.north == null) {
				return true;
			}else {
				return !this.north.blocked;
			}			
		}
		if(a == 1) {
			if (this.south == null) {
				return true;
			}else {
				return !this.south.blocked;
			}			
		}
		if(a == 2) {
			if (this.east == null) {
				return true;
			}else {
				return !this.east.blocked;
			}			
		}
		if(a == 3) {
			if (this.west == null) {
				return true;
			}else {
				return !this.west.blocked;
			}			
		}
		return !state_nextplace;
	}
    
	public Place GetnextPlace_direction(int a) {
		Place nextplace = null;
		if(a == 0) {
			nextplace = this.north;
		}
		if(a == 1) {
			nextplace = this.south;
		}
		if(a == 2) {
			nextplace = this.east;
		}
		if(a == 3) {
			nextplace = this.west;
		}
		return nextplace;
	}
	
}
