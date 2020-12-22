function LocationController($scope, $location) {
    if($location.$$absUrl.lastIndexOf('/contacts') > 0){
        $scope.activeURL = 'contacts';
    } else if($location.$$absUrl.lastIndexOf('/addproduct') > 0){
        $scope.activeURL = 'addproduct';
    }
    else{
        $scope.activeURL = 'home';
    }
}