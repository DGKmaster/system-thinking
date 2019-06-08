package system_thinking;

public class Location {
    int geo_id;
    String geoname;
    Float lon;
    Float lat;
    String description;
    String img;
    Float rating;

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getGeo_id() {
        return geo_id;
    }

    public void setGeo_id(Integer geo_id) {
        this.geo_id = geo_id;
    }

    public String getGeoname() {
        return geoname;
    }

    public void setGeoname(String geoname) {
        this.geoname = geoname;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Location(int geo_id, String geoname, Float lon, Float lat, String description, String img, Float rating) {
        this.geo_id = geo_id;
        this.geoname = geoname;
        this.lon = lon;
        this.lat = lat;
        this.description = description;
        this.img = img;
        this.rating = rating;
    }
}
