$( document ).ready(() => {

    $(document).on("click", "#night", () => {

        $("body").addClass("bg-dark")
        $("main").removeClass("bg-secondary");
        $("main").addClass("bg-light");
    })

    $(document).on("click", "#day", () => {

        $("body").removeClass("bg-dark")
        $("main").removeClass("bg-light")
        $("main").addClass("bg-secondary")
    })

})