var marker = null;

function handleMessage(data) {
    var coords = new google.maps.LatLng(data.lat, data.lng);

    if (marker == null){
        marker = new google.maps.Marker();
        map.addOverlay(marker);
    }
    marker.setPosition(coords);

    map.infowindow = new google.maps.InfoWindow({
        content: '<h3>' + data.username + " just sent a message!</h3>"
    });
    map.infowindow.open(map.getMap(), marker);


    var logs = $(PrimeFaces.escapeClientId('logs'));
    logs.append(data.username+' : ' + data.message + '<br />');
    logs.scrollTop(logs.height());

    map.getMap().setCenter(coords);
    //console.log(data);
}

$(function() {
    navigator.geolocation.getCurrentPosition(
        function(position) {
            var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            map.getMap().setCenter(coords);
        },
        function(error) {
            console.log(error.message);
        },
        {
            enableHighAccuracy: true
        });
});