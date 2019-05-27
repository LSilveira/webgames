$(document).ready(function(){

    $("#newGame").click(function(){

        $("#gameForm").submit();

    });

    $("#submitGuess").on("click", function(){

        var totalGuesses = parseInt($("#totalGuesses").text());
        var state = parseInt($("#state").text());
        var guessWord = $("#guessWord").val();
        var playerName = $("#playerName").val();

        if (totalGuesses < 9 || state === "STARTED" ){

            if( !guessWord.trim() || !playerName.trim() ){

                        alert("Invalid fields!");

                    }
                    else{

                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: "/game/hangman",
                            dataType: 'html',
                            data: JSON.stringify({ "guessWord": guessWord, "playerName": playerName }),
                            success: function (response) {

                                $("#hangmangTable").html(response);

                            },
                            error: function (response) {

                                console.log(response);
                                alert("Error loading game data! \n" + response.responseJSON.message);

                            }
                        })
                    }

        }
        else{
            alert("Game is over!");
        }

    });

});