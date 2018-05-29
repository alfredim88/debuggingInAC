package org.academiadecodigo.debuggingac;

public enum FolderType {

    CAR_CRASH("/resources/images/game/folder_arabian-nights.png"),
    SNIPER_ELITE("/resources/images/Folders-PNG-File.png"),
    GUESS_A_NUMBER("/resources/images/game/folder_guess-a-number.png"),
    ARABIAN_NIGHT("/resources/images/game/folder_arabian-nights.png"),
    HOTEL("/resources/images/game/folder_hotel.png"),
    MONEY_IN_THE_BANK("/resources/images/game/folder_arabian-nights.png"),
    ROCK_PAPER_SCISSORS("/resources/images/Folders-PNG-File.png"),
    HELLO_WORLD("/resources/images/Folders-PNG-File.png");

    private String folderPic;

    FolderType(String folderPic){
        this.folderPic = folderPic;
    }

    public FolderType getRandomFolder(){

        return FolderType.values()[(int)(Math.random() * FolderType.values().length)];

    }

}