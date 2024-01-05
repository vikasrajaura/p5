    // Script to open and close the sidebar
    function w3_open() {
      document.getElementById("main-sidebar").style.display = "block";
      document.getElementById("main-overlay").style.display = "block";
    }
    function w3_close() {
      document.getElementById("main-sidebar").style.display = "none";
      document.getElementById("main-overlay").style.display = "none";
    }

    function w3_open1() {
      document.getElementById("content-sidebar").style.display = "block";
      document.getElementById("content-overlay").style.display = "block";
    }
    function w3_close1() {
      document.getElementById("content-sidebar").style.display = "none";
      document.getElementById("content-overlay").style.display = "none";
    }



    function w3_show_nav(name) {
        if (name=="menu1" || name=="menu2") {
              document.getElementById("menu1").style.display = "none";
              document.getElementById("menu2").style.display = "none";
        }
        else{
              document.getElementById("menuTut").style.display = "none";
              document.getElementById("menuRef").style.display = "none";
              document.getElementById("menuFx").style.display = "none";
        }
      document.getElementById(name).style.display = "block";
    }






    function openCity(evt, cityName) {
      var i, x, tablinks;
      x = document.getElementsByClassName("city");
      for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
      }
      tablinks = document.getElementsByClassName("tablink");
      for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" w3-theme-l2", "");
      }
      document.getElementById(cityName).style.display = "block";
      evt.currentTarget.className += " w3-theme-l2";
    }