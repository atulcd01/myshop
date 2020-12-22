function gup( name, url ) {
		    if (!url) url = location.href;
		    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
		    var regexS = "[\\?&]"+name+"=([^&#]*)";
		    var regex = new RegExp( regexS );
		    var results = regex.exec( url );
		    return results == null ? null : results[1];
		}

function categoryController($scope, $http, $window,$location,$rootScope) {
    $scope.pageToGet = 0;
    $scope.state = 'busy';
    $scope.cartcount = 0;
    $scope.ids = "";
    $scope.lastAction = '';
    var pId = window.location.href.split(/[\s/]+/).pop();
	var loc = pId.split('?');
	pId = loc[0]; 
	$scope.pId = pId;
	$scope.parameter = loc[1];
	$rootScope.localip = 

	$rootScope.contextpath = "http://linux.machine.com/";
	//alert("baseurl->"+baseurl) $rootScope.contextpath = "http://localhost:8080/function";
	$rootScope.webpath = baseurl;
    $scope.url = $rootScope.contextpath+"/category-service/category/";
    $scope.carturl = $rootScope.contextpath+"/cart-service/protected/cart/count?"+$scope.parameter;
    $scope.apppropertiesurl = $rootScope.contextpath+'/application-service/application?'+$scope.parameter;
    $scope.brand =''
    $scope.autolist=[];
    
    $scope.record = {}

 
    $scope.search = function (parent, appid ){
    	
    	console.log(parent + '   ' + parent);
    	$window.location.href=$rootScope.contextpath+'/search-service/protected/products/'+parent.trim()+'?a='+appid;
    }
    $scope.autocomplete =  function () {
    	 	var x = document.getElementById("searchtext");
    	  	$scope.autolist=[];
    	  	// from product list 
    	  	$scope.page.sourcelist
    	  	
    	  	angular.forEach($scope.page.sourcelist, function(cat) {
    	  
    	  	if(x.value==''){
    	  		$scope.autolist=[];
    	  	}
    	  	else if(cat.name.toLowerCase().indexOf(x.value.toLowerCase())>=0 && cat.someadditionalattr){
    	  			$scope.autolist.push(cat);
    	  		}
    		    });
    	    
    	    
    	}
  
    $scope.getRecordList = function () {
    var param = gup('a', $location.absUrl());
    	//alert('getting records for application '+ param);
    	if(param==null)
    		param = 0;
        var url = $scope.url+'list/'+param+'/';
       // var url = $scope.url+'list/1/';
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest();

        var config = {params: {page: $scope.pageToGet}};

        $http.get(url, config)
            .then(function (data) {
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
            },
            function () {
                $scope.state = 'error';
            });
    }
    
    
    $scope.getCartCount = function () {
        var url = $scope.carturl;
        $scope.startDialogAjaxRequest();

        var config = {headers: {'email': $scope.email}};

        $http.get(url, config)
            .then(function (data) {
            	
            	//alert(JSON.stringify(data));
            	 $scope.cartcount = data.data.count;
            	 $scope.ids = data.data.ids;
            	 //alert('ids'+data.ids);
            	 
            },function () {
                $scope.state = 'error';
            });
    }


    $scope.populateTable = function (data) {
    	
    	//console.log(JSON.stringify(data.menuBaseCategory));

    	$scope.page = {source: data.menuBaseCategory, sourcelist: data.productList};
           

    }

     $scope.startDialogAjaxRequest = function () {
        $scope.displayValidationError = false;
        $("#loadingModal").modal('show');
        $scope.previousState = $scope.state;
        $scope.state = 'busy';
    }

    $scope.finishAjaxCallOnSuccess = function (data, modalId, isPagination) {
        $scope.populateTable(data);
        $("#loadingModal").modal('hide');

        if(!isPagination){
            if(modalId){
                $scope.exit(modalId);
            }
        }
        $scope.lastAction = '';
    }
   /*this has to be written */
    $scope.getBrand = function () {
    	var config = {};
    	url = $scope.apppropertiesurl;
    	console.log(url)
        $http.get(url, config)
        .then(function (data) {
        	$scope.brand=data.data[0].name;
        },
        function () {
        	//console.log(response);
        	$scope.brand='Brand error';
        });
    	
    }
    	
    
    
    $scope.logout = function () {

    	$http.post('/login/logout').then(function () { 
			$window.sessionStorage.setItem('user',null);
			$scope.user="";
			$window.location = $window.location;
		},function () { 
			alert('logout error');
		});
       

}
    
	$scope.showLogin = function() {
		
	    	var dlgElem = angular.element("#loginModal");
	    	if (dlgElem) {
    	    	dlgElem.scope().toogleloginreg = false;
    	    	dlgElem.modal("show");
    	    	dlgElem.scope().toogleloginregf = function () { 
    	    		dlgElem.scope().loginerrmsg = '';
    				if(dlgElem.scope().toogleloginreg)
    					dlgElem.scope().toogleloginreg=false;
    				else
    					dlgElem.scope().toogleloginreg=true;
    			}
    	    	
	var scope = dlgElem.scope();
	scope.login = function () {
		var url = '/login/login/?'+$scope.parameter;
		var logindata = {'email': scope.email, 'password': scope.password, 'applicationId':gup('a', url)};
		scope.lastAction = 'login';
		
		var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
		$scope.startDialogAjaxRequest();

		$http.post(url, JSON.stringify(logindata))
		.then(function (data) {
			//alert(JSON.stringify(data.data));
			scope.loginerrmsg='';
			//alert($window.location+'?a='+data.applicationId)
			$window.location = $window.location;
			console.log('user data ->'+JSON.stringify(data.data));
			$window.sessionStorage.setItem('user', JSON.stringify(data.data));
			$scope.user = data.data;
			
		},function(data, status, headers, config) {
			scope.loginerrmsg = 'username or password is incorrect';
			console.log('username or password is incorrect');
		});
	}
    	    	
    	    	
    	    	scope.registerUser = function () { 
    	    		scope.reguser.role='ROLE_USER';
    	    		scope.reguser.enabled=true;
    	    		scope.reguser.applicationId=gup('a', $scope.carturl);
    	    		var url = '/login/register/';
    	    		var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
    	    		$scope.startDialogAjaxRequest();
    	    		$http.post(url, $.param(scope.reguser), config)
    	    		.then(function (data) {
    	    			//alert(JSON.stringify(data));
    	    			$window.sessionStorage.setItem('user', JSON.stringify(data.data));
    	    			$scope.user = data.data;
    	    			$window.location = $window.location;
    	    		},function(data, status, headers, config) {
    	    			scope.loginerrmsg = 'user cannot be registered';
    	    			//   $scope.handleErrorInDialogs(status);
    	    		});
    	    	};
	    	    	
	       dlgElem.on("hide.bs.modal", function() {
	          
	    	   console.log("login cancelled");
	    	   
	       });
	       
	    	}
	    	
	    };
	   
	    $scope.getUserEmailfromSession = function () { 
	    	
	    	try {
	    		$scope.user = $window.sessionStorage.getItem('user');
		    	$scope.user = JSON.parse($scope.user);
		    	$scope.email = $scope.user.email;
	  
	    	}
	    	catch(err) {
	    		$scope.email = null;
	    		}
	    }
	    $scope.getUserFromSession = function () { 
	    	
	    	$scope.user = $window.sessionStorage.getItem('user');
	    	//alert(JSON.stringify($scope.user));
	    	//alert(JSON.parse(JSON.stringify($scope.user)));
	    	$scope.user = JSON.parse($scope.user);
	    	//alert($scope.user.email)
	    }
$scope.getBrand();	    
$scope.getUserFromSession();
$scope.getUserEmailfromSession();
$scope.getRecordList();
$scope.getCartCount();

}