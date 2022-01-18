;(function(){
function authInterceptor(API, auth,$window) 
{
  return {
    request: function(config) 
    {
      if(auth.getToken() && config.url.indexOf(API) === 0)
      {
        config.headers.Authorization = 'Bearer ' + auth.getToken();
      }
      return config;
    },
    response: function(res) 
    {
      /*if(res.config.url.indexOf(API) === 0 && res.data.accessToken)
      {
        auth.saveToken(res.data.accessToken)
      }*/

      /*
      if(res.status == 401)
      {
        $window.location.href = 'index.html'
      }*/

      return res;
    },
  }
}

function authService($window) 
{
  var self = this;
  self.parseJwt = function(token) 
  {
    return JSON.parse($window.atob(token.split('.')[1].replace('-', '+').replace('_', '/')));
  }

  self.saveToken = function(token) 
  {
    $window.localStorage['jwtToken'] = token;
  }

  self.getToken = function() 
  {
    return $window.localStorage['jwtToken'];
  }

  self.logout = function()
  {
    $window.localStorage.removeItem('jwtToken')
  }

}

function userService($http, API) 
{
  var self = this;

  self.register = function(username,password,nom,prenom) 
  {
    return $http.post(API + '/auth/signup',{username: username,password: password,nom: nom,prenom: prenom})
  }

  self.login = function(username, password) 
  {
    return $http.post(API + '/auth/signin', {username: username,password: password})
  };

  self.getAllEmployees = function()
  {
     return $http.get("http://localhost:8072/api/v1/employees")
  }
}

function MainCtrl(user, auth,$window) 
{
    var self = this;
    self.valiny = "koko";
    function handleRequest(res) 
    {
       self.message = res.data; 
    }

    self.login = function() 
    { 
      user.login(self.username, self.password).then(function(res)
      {
          if(res.data.accessToken)
          {
            auth.saveToken(res.data.accessToken)
            $window.location.href = 'page.html';
          }
          else 
          {
            self.info = 'Error !!';
          }
      })
    }

    self.register = function() 
    { 
      user.register(self.username,self.password,self.nom,self.prenom).then(function(res)
      {
          $window.location.href = 'page.html';
      })
    }

    self.getAllEmployees = function()
    {
      user.getAllEmployees().then(function(response) 
      {
        console.log(response.data);
      });
    }

    self.logout = function() 
    { 
      auth.logout()
    }

    self.getUser = function() 
    { 
      self.user = auth.parseJwt(auth.getToken()) 
    }

}

angular.module('app', []).factory('authInterceptor', authInterceptor).service('user', userService).service('auth', authService).constant('API', 'http://localhost:8072/api').config(function($httpProvider) { $httpProvider.interceptors.push('authInterceptor');}).controller('Main', MainCtrl)

})();