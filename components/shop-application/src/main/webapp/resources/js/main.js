var jsaApp = angular.module('Application', ['ngSanitize']);
 
jsaApp.controller('categoryController', categoryController);
jsaApp.controller('productsController', productsController);
jsaApp.controller('viewController', viewController);
jsaApp.controller('cartController', cartController);
jsaApp.controller('ordersViewController', ordersViewController);

jsaApp.controller('orderController', orderController);
jsaApp.controller('ordersController', ordersController);
jsaApp.controller('trackOrderController', trackOrderController);


var baseurl = 'http://linux.machine.com/shop-application';






// DIRECTIVE - FILE MODEL
jsaApp.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
}]); 