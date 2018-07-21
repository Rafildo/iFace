import java.util.Scanner;


public class Main {
    static String[] userUserName = new String[100];
    static String[] password = new String[100];
    static String[] name = new String[100];
    static String[][] userAttributeData = new String[100][100];
    static String[][] userAttributeName = new String[100][100];
    static String[][] userFriends = new String[100][100];
    static String[][] userPendingFriendship = new String[100][100];
    static String[][] userMessages = new String[100][100];
    static String[][] userCommunities = new String[100][100];
    static String[][] communityMembers = new String[100][100];
    static String[] communities = new String[100];
    static String[] communityDescription = new String[100];
    static String[][] communitiesPendingAcess = new String[100][100];
    static String[][] communitiesMessage = new String[100][100];
    static boolean end = false;


    public static void main(String[] args) {
        while (!end) {
            displayMenu();
        }
    }

    public static void displayMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao iFace!");
        System.out.println("1: Cadastrar Usuário");
        System.out.println("2: Logar");
        System.out.println("3: Sair");
        int choice = input.nextInt();
        if (choice == 1) {
            signIn();
        } else if (choice == 2) {
            logIn();
        } else if (choice == 3) {
            end = true;
        }

    }

    public static void signIn() {
        String username;
        String pass;
        String newname;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {
            if (userUserName[i] == null) {
                System.out.println("Nome de usuário:");
                username = input.nextLine();
                userUserName[i] = username;
                System.out.println("Senha:");
                pass = input.nextLine();
                password[i] = pass;
                System.out.println("Nome:");
                newname = input.nextLine();
                name[i] = newname;
                break;
            }
        }
    }

    public static void logIn() {
        int i;
        Scanner input = new Scanner(System.in);
        System.out.println("Nome de usuário:");
        String logUser = input.nextLine();
        System.out.println("Senha:");
        String logPassword = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (userUserName[i] != null) {
                if (logUser.equals(userUserName[i]) && logPassword.equals(password[i])) {
                    System.out.println("Logado com sucesso!");
                    userProfile(i);
                }
            }

        }
        if (i == 100)
        {
            System.out.println("Usuário não encontrado");
        }
    }

    public static void userProfile(int index) {
        boolean var = false;
        while (!var) {
            Scanner input = new Scanner(System.in);
            System.out.println("Bem vindo ao seu Perfil," + name[index]);
            System.out.println("1: Criar atributos do perfil");
            System.out.println("2: Editar atributos do perfil");
            System.out.println("3: Adicionar amigo");
            System.out.println("4: Enviar mensagem a usuário");
            System.out.println("5: Criar comunidade");
            System.out.println("6: Gerenciar comunidade");
            System.out.println("7: Juntar-se a uma comunidade");
            System.out.println("8: Checar mensagens");
            System.out.println("9: Solicitações de amigo");
            System.out.println("10: Lista de amigos");
            System.out.println("11: Lista de comunidades");
            System.out.println("12: Ver atributos do Perfil");
            System.out.println("13: Enviar mensagem a comunidade");
            System.out.println("14: Remover conta");
            System.out.println("15: Voltar(Logout)");
            int choice = input.nextInt();
            if (choice == 1) {
                attributeCreate(index);
            } else if (choice == 2) {
                attributeEdit(index);
            } else if (choice == 3) {
                friendAdd(index);
            } else if (choice == 4) {
                friendMessage(index);
            } else if (choice == 5) {
                communityCreate(index);
            } else if (choice == 6) {
                communityManage(index);
            } else if (choice == 7) {
                communityJoin(index);
            } else if (choice == 8) {
                messageCheck(index);
            } else if (choice == 9) {
                friendRequest(index);
            } else if (choice == 10) {
                friendList(index);
            } else if (choice == 11) {
                displayUserCommunities(index);
            } else if (choice == 12) {
                atrributeDisplay(index);
            } else if (choice == 13) {
                communityMessage(index);
            } else if (choice == 14) {
                removeAccount(index);
                var = true;
            } else if (choice == 15) {
                var = true;
            }
        }
    }

    public static void removeAccount(int userIndex) {
        int i, j, l;
        String auxiliar;
        Scanner input = new Scanner(System.in);
        System.out.println("Tem certeza que deseja remover a conta?");
        System.out.println("1: Sim");
        System.out.println("2: Não");
        int choice = input.nextInt();
        if (choice == 1) {
            for (i = 0; i < 100; i++) {
                userCommunities[userIndex][i] = null;
                userAttributeData[userIndex][i] = null;
                userAttributeName[userIndex][i] = null;
                userFriends[userIndex][i] = null;
                userPendingFriendship[userIndex][i] = null;
            }
            for (i = 0; i < 100; i++) {
                for (j = 0; j < 100; j++) {
                    if (communityMembers[i][j] != null && communityMembers[i][j].equals(name[userIndex])) {
                        communityMembers[i][j] = null;
                    }
                }
            }
            for (i = 0; i < 100; i++) {
                if (userMessages[userIndex][i] != null) {
                    auxiliar = userMessages[userIndex][i];
                    for (j = 0; j < 100; j++) {
                        for (l = 0; l < 100; l++) {
                            if (userMessages[j][l] != null && userMessages[j][l].equals(auxiliar)) {
                                userMessages[j][l] = null;
                                userMessages[userIndex][i] = null;
                            }
                        }
                    }
                }
            }
            userUserName[userIndex] = null;
            password[userIndex] = null;
            name[userIndex] = null;
        } else if (choice == 2) {
            System.out.println("Retornando ao perfil...");
        }
    }

    public static void attributeCreate(int userIndex) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do atributo:");
        String attributeName = input.nextLine();
        for (int i = 0; i < 100; i++) {
            if (userAttributeName[userIndex][i] == null) {
                userAttributeName[userIndex][i] = attributeName;
                System.out.println("Insira o dado do atributo:");
                String attributeData = input.nextLine();
                userAttributeData[userIndex][i] = attributeData;
                break;
            }
        }
    }

    public static void atrributeDisplay(int userIndex) {
        for (int i = 0; i < 100; i++) {
            if (userAttributeName[userIndex][i] != null)
                System.out.printf("%s: %s%n", userAttributeName[userIndex][i], userAttributeData[userIndex][i]);
        }
    }

    public static void attributeEdit(int userIndex) {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual atributo deseja editar?");
        String attribute = input.nextLine();
        for (int i = 0; i < 100; i++) {
            if (userAttributeName[userIndex][i].equals(attribute)) {
                System.out.println("Insira o novo atributo:");
                String newAttribute = input.nextLine();
                userAttributeData[userIndex][i] = newAttribute;
                break;
            }
        }
    }


    public static void friendAdd(int userIndex) {
        int i, j;
        Scanner input = new Scanner(System.in);
        System.out.println("Amigo à adicionar:");
        String friend = input.nextLine();
        String text = "Solicitação de: ";
        for (i = 0; i < 100; i++) {
            if (friend.equals(name[i])) {
                for (j = 0; j < 100; j++) {
                    if (userPendingFriendship[i][j] == null) {
                        userPendingFriendship[i][j] = name[userIndex];
                        System.out.println("Solicitação enviada");
                        break;
                    }
                }
            }
        }
        if (i == 100)
        {
            System.out.println("Usuário não encontrado");
        }
    }

    public static void friendRequest(int userIndex) {
        int i, j, l;
        Scanner input = new Scanner(System.in);
        String text = "Solicitação de: ";
        System.out.println("Solicitações pendentes");
        for (i = 0; i < 100; i++) {
            if (userPendingFriendship[userIndex][i] != null) {

                System.out.printf("%s(%d) %s%n", text, i, userPendingFriendship[userIndex][i]);
            }
        }
        System.out.println("Aceitar solicitação de número:");
        int choice = input.nextInt();
        for (i = 0; i < 100; i++) {
            if (name[i] != null && userPendingFriendship[userIndex][choice].equals(name[i]))
                break;
        }

        for (j = 0; j < 100; j++) {
            if (userFriends[userIndex][j] == null) {
                userFriends[userIndex][j] = name[i];
                break;
            }
        }
        for (l = 0; l < 100; l++) {
            if (userFriends[i][l] == null) {
                userFriends[i][l] = name[userIndex];
                break;
            }
        }
        userPendingFriendship[userIndex][choice] = null;
    }

    public static void friendMessage(int userIndex) {
        int i, j ,l;
        Scanner input = new Scanner(System.in);
        System.out.println("Enviar mensagem para:");
        String friend = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (friend.equals(name[i])) {
                System.out.println("Mensagem:");
                String message = input.nextLine();
                for (j = 0; j < 100; j++) {
                    if (userMessages[userIndex][j] == null) {
                        String text = String.valueOf(name[userIndex]) + " disse para " + name[i] + ": " + message;
                        userMessages[userIndex][j] = text;
                        break;
                    }
                }
                for (l = 0; l < 100; l++) {
                    if (userMessages[i][l] == null) {
                        String text = String.valueOf(name[userIndex]) + " disse para " + name[i] + ": " + message;
                        userMessages[i][l] = text;
                        break;
                    }
                }
            }
        }
        if (i == 100)
        {
            System.out.println("Usuário não encontrado");
        }
    }

    public static void communityMessage(int userIndex) {
        int i, j, l, savei = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Qual comunidade deseja enviar uma mensagem?");
        String community = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (communities[i] != null && communities[i].equals(community)) {
                savei = i;
                break;
            }
        }
        if (i == 100)
        {
            System.out.println("Comunidade não encontrada");
        }
        else {
            System.out.println("Mensagem:");
            String message = input.nextLine();
            for (j = 0; j < 100; j++) {
                if (communitiesMessage[savei][j] == null) {
                    String text = String.valueOf(name[userIndex]) + " enviou para " + community + ": " + message;
                    communitiesMessage[savei][j] = text;
                    break;
                }
            }
            for (l = 0; l < 100; l++) {
                if (userMessages[userIndex][l] == null) {
                    String text = String.valueOf(name[userIndex]) + " enviou para " + community + ": " + message;
                    userMessages[userIndex][l] = text;
                    break;
                }
            }
        }
    }

    public static void friendList(int userIndex) {
        for (int i = 0; i < 100; i++) {
            if (userFriends[userIndex][i] != null) {
                System.out.println(userFriends[userIndex][i]);
            }
        }
    }

    public static void messageCheck(int userIndex) {
        for (int i = 0; i < 100; i++) {
            if (userMessages[userIndex][i] != null) {
                System.out.println(userMessages[userIndex][i]);
            }
        }
    }

    public static void communityMessageCheck(int communityIndex) {
        for (int i = 0; i < 100; i++) {
            if (communitiesMessage[communityIndex][i] != null) {
                System.out.println(communitiesMessage[communityIndex][i]);
            }
        }
    }

    public static void communityCreate(int index) {
        Scanner input = new Scanner(System.in);
        int i, j, l;
        System.out.println("Nome da comunidade:");
        String communityName = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (userCommunities[index][i] == null) {
                userCommunities[index][i] = communityName;
                break;
            }
        }
        for (l = 0; l < 100; l++) {
            if (communities[l] == null) {
                communities[l] = communityName;
                System.out.println("Descrição da comunidade:");
                String description = input.nextLine();
                communityDescription[l] = description;
                break;
            }
        }
        for (j = 0; j < 100; j++) {
            if (communityMembers[l][j] == null) {
                communityMembers[l][j] = name[index];
                break;
            }
        }
    }

    public static void communityManage(int index) {
        int i;
        Scanner input = new Scanner(System.in);
        System.out.println("Qual comunidade deseja gerenciar?");
        String communityName = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (userCommunities[index][i] != null && userCommunities[index][i].equals(communityName)) {
                break;
            }

        }
        if (i == 100)
        {
            System.out.println("Comunidade não encontrada");
        }
        else {
            communityManagementSystem(index, i);
        }
    }

    public static void displayUserCommunities(int userIndex) {
        for (int i = 0; i < 100; i++) {
            if (userCommunities[userIndex][i] != null)
                System.out.println(userCommunities[userIndex][i]);
        }
    }

    public static void communityManagementSystem(int userIndex, int communityIndex) {
        System.out.printf("Gerenciamento da comunidade %s%n", communities[communityIndex]);
        System.out.printf("Descrição da comunidade: %s%n", communityDescription[communityIndex]);
        boolean var = false;
        while (!var) {
            Scanner input = new Scanner(System.in);
            System.out.println("O que deseja fazer?");
            System.out.println("1: Listar membros");
            System.out.println("2: Remover membro");
            System.out.println("3: Gerenciar solicitações");
            System.out.println("4: Checar mensagens");
            System.out.println("5: Voltar ao perfil");
            int choice = input.nextInt();
            if (choice == 1) {
                printCommunityMembers(communityIndex);
            } else if (choice == 2) {
                removeMember(communityIndex);
            } else if (choice == 3) {
                communityManageRequestAcess(userIndex, communityIndex);
            } else if (choice == 4) {
                communityMessageCheck(communityIndex);
            } else if (choice == 5) {
                var = true;
            }
        }
    }

    public static void printCommunityMembers(int communityIndex) {
        int memberCount = 0;
        for (int i = 0; i < 100; i++) {
            if (communityMembers[communityIndex][i] != null) {
                System.out.println(communityMembers[communityIndex][i]);
                memberCount++;
            }
        }
        System.out.printf("Total de membros: %d%n", memberCount);
    }

    public static void removeMember(int communityIndex) {
        int i, j, l;
        Scanner input = new Scanner(System.in);
        System.out.println("Membro a remover:");
        String member = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (communityMembers[communityIndex][i].equals(member)) {
                communityMembers[communityIndex][i] = null;
                break;
            }
        }
        for (j = 0; j < 100; j++) {
            if (name[j].equals(member)) {
                break;
            }
        }
        for (l = 0; l < 100; l++) {
            if (userCommunities[j][l].equals(communities[communityIndex]) && userCommunities[j][l] != null) {
                userCommunities[j][l] = null;
                break;
            }
        }
    }


    public static void communityJoin(int userIndex) {
        int i;
        Scanner input = new Scanner(System.in);
        System.out.println("Comunidade a entrar:");
        String community = input.nextLine();
        for (i = 0; i < 100; i++) {
            if (communities[i] != null && communities[i].equals(community)) {
                break;
            }
        }
        if (i == 100)
        {
            System.out.println("Comunidade não encontrada");
        }
        else {
            communityRequestAcess(userIndex, i);
        }
    }

    public static void communityRequestAcess(int userIndex, int communityIndex) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            if (communitiesPendingAcess[communityIndex][i] == null) {
                communitiesPendingAcess[communityIndex][i] = name[userIndex];
                break;
            }
        }

    }

    public static void communityManageRequestAcess(int userIndex, int communityIndex) {
        int i, j, l;
        Scanner input = new Scanner(System.in);
        System.out.println("Lista de solicitações");
        for (i = 0; i < 100; i++) {
            if (communitiesPendingAcess[communityIndex][i] != null)
                System.out.printf("%d:%s%n", i, communitiesPendingAcess[communityIndex][i]);
        }
        System.out.println("Aprovar solicitação de número:");
        int choice = input.nextInt();
        for (i = 0; i < 100; i++) {
            if (name[i].equals(communitiesPendingAcess[communityIndex][choice])
                    && communitiesPendingAcess[communityIndex][choice] != null)
                break;
        }
        for (j = 0; j < 100; j++) {
            if (communityMembers[communityIndex][j] == null) {
                communityMembers[communityIndex][j] = name[i];
                break;
            }
        }
        for (l = 0; l < 100; l++) {
            if (userCommunities[i][l] == null) {
                userCommunities[i][l] = communities[communityIndex];
                break;
            }
        }
        communitiesPendingAcess[communityIndex][choice] = null;
    }
}
