package main
import (
	"fmt"
	"net/url"

)
type Point struct
{
	Latitude float64;
	Longitude float64;
}
type Polygon struct
{
	Points []Point
}
func (point *Point) toString() string {
    return fmt.Sprintf("%f,%f", point.Latitude, point.Longitude)
}
func (polygon *Polygon) toString() string {
    var result string
    var points []string
    for _, point := range polygon.Points {
        points = append(points, point.toString())
    }
    result = strings.Join(points, ",")
    return result
}

func main() {
    polygon := Polygon{
        Points: []Point{
            Point{Latitude: 37.7397, Longitude: -121.4252},
            Point{Latitude: 37.7974, Longitude: -121.2161},
            Point{Latitude: 37.6391, Longitude: -120.9969},
            Point{Latitude: 37.7397, Longitude: -121.4252},
        },
    }
    fmt.Println(polygon.toString())
}
func GetMapWithPolygon(output string, geometry string) {
    endpoint, _ := url.Parse("https://places.ls.hereapi.com/places/v1/discover/explore;context=Y2F0PXNpZ2h0cy1tdXNldW1zJmZsb3ctaWQ9Yjk1ZGY3NWUtNTc2ZC01NTU1LWIyYjgtMDhiMTcxYTcxNzIwXzE1OTQwNTc0NzE1NzVfMF82Mzg5Jm9mZnNldD0yMCZzaXplPTIw?at=52.5159%2C13.3777" )
    queryParams := endpoint.Query()
    queryParams.Set("app_id", "LKO34glU2MBEVbcOD5mQ")
    queryParams.Set("app_code", "A2ta_nQ8HRYwenju5HFG5Q")
    queryParams.Set("ppi", "320")
    queryParams.Set("w", "1280")
    queryParams.Set("h", "720")
    queryParams.Set("z", "11")
    queryParams.Set("a0", geometry)
    endpoint.RawQuery = queryParams.Encode()
    response, err := http.Get(endpoint.String())
    if err != nil {
        fmt.Printf("The HTTP request failed with error %s\n", err)
    } else {
        f, _ := os.Create(output)
        data, _ := ioutil.ReadAll(response.Body)
        f.Write(data)
        defer f.Close()
    }
func main(){
	 fmt.Println("!... Hello output ...!") 
	 polygon := Polygon{
        Points: []Point{
            Point{Latitude: 37.7397, Longitude: -121.4252},
            Point{Latitude: 37.7974, Longitude: -121.2161},
            Point{Latitude: 37.6391, Longitude: -120.9969},
            Point{Latitude: 37.7397, Longitude: -121.4252},
        },
    }
    GetMapWithPolygon("map.jpg", polygon.toString())

}
