package fxc;

/**
 * Represents an attribute in an xml element. This can be either
 * a single element or a key and value pair.
 * 
 * @author je bailey
 * 
 */
public class Attribute {

	private boolean paired;

	private String key;

	private String value;

	public Attribute(String key) {
		this.key = key;
	}

	public Attribute(String key, String value) {
		this.paired = true;
		this.key = key;
		this.value = value;
	}

	public Attribute(String key, Object value) {
		this(key, String.valueOf(value));
	}
	
	public boolean update(Attribute other){
		if (!this.equals(other)){
			return false;
		}
		this.value = other.value;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Attribute other = (Attribute) obj;
		if (key == null) {
			if (other.key != null){
				return false;
			}
		} else if (!key.equals(other.key)){
			return false;
		}
		return true;
	}

	public String toString() {
		return (paired) ? String.format("%s='%s'", key, value) : key;
	}

}
