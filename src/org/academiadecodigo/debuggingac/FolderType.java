package org.academiadecodigo.debuggingac;

public enum FolderType {
    CAR_CRASH("/resources/images/Folders-PNG-File.png"),
    SNIPER_ELITE("/resources/images/Folders-PNG-File.png"),
    GUESS_A_NUMBER("/resources/images/Folders-PNG-File.png"),
    ARABIAN_NIGHT("/resources/images/Folders-PNG-File.png"),
    HOTEL("/resources/images/Folders-PNG-File.png"),
    MONEY_IN_THE_BANK("/resources/images/Folders-PNG-File.png"),
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