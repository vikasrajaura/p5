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
      document.getElementById("menuTut").style.display = "none";
      document.getElementById("menuRef").style.display = "none";
      document.getElementById(name).style.display = "block";
      w3-open();
    }
