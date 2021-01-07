# include <stdio.h>
# include <stdlib.h>
# include <time.h>
# include <math.h>

int main() {

	// give Cipher text as an input
	char Cipher[] = "HRDKHUBHAAMAEQMTMZSHGBAKFUBHAASYRXUNKYUAATQCTLUTOGEWVAJGVEIIYTKIOTQRXXQVSQLISVVOCNGCUXPKPIUBOHTVKCFKWNJSEZYSSUTUOESIXKAPVFXNZHAOQTLCGYJVAEHLNNKEESQMKSHKKDFCNZSRHRDKHSDKFXVPTGMKRUPZBIKEVNYEKXMFXKFYMWYUDZDENEWNKDAOUXGPCXZDLCSNFGCMCSNUAOJDBLQTAHEWYZCHQJYKSNUWOKQKONZGOKDXGUXKEMWQMCFGUEAVKHDIIATCHVTGYMGKJMLNPCNAYKMIRWEETIYQKELEGLQOVKISFNUDAJQIQYBXQTMZSHGBAKFZRCNWRSODAFKKXWGAZGDBIUDDHCUDFRFOVSZXADSHYSGLTQBMNEMKDCFSOZSRDYLIHIAXCMGMFEIDNZKOVJEOIEFNWWQEDRLZYZIZXADSHYSGLJYFWDUAKSIOGOZOXWYPBUFEPNBIRJUJNDZJJYMURKNCIKPWLRMRIAGVSXTYNIWPROHLDHQOMBEKZURQCLQOVKISFNUAFQBHGPCLHZTPJVPXIZKLQSNVKIJAEITTNVSVWNFYVATDEMKDCTGIHKZTVGZYXTYQEDBACFMNCAHRDKHSDKFXZXXGMJOSLPSZBMOILMMWRALAFFMNXXDYFBIYQVVOHSWKGBIRJGTBYQLKIJAEQBTAXGFGAVUIJADHQKLFWRJXYFVIGGQZNBHSUIYOZALSKIABLWQNXNXKOAJAIKHXODXWORVDOGBMHOPLQJZALQJZALIKTKLENZHQAVYUEUFEVLUXHGOWNMGWXUIAHGQOMNCKFQLIPBNKVWDLNGMJCOBFKIGBYWPAHMMPQLUTOGECXITZVVAJEOIDCNWMFNLOBGQXCYFWQFWVXWRKWYGBFHJVLBAWBOUQEKHZHSZZIZARYITDCLQFPGBTJMQVSQLIHPEJONCYMZWTVJVZOBOMOHPSXMPUKVAGXIPOQUQUQBCKXZJSZAHEWYHAEMKOJCCCFBEUKVNCAWANSNXISVVOWHQGQFBGWKQEGBIFRGIZUJQWIMFANTGBHWGVAGXIPOQUQTTRMWDHDGRFENKYPZVCLNQAUBTZSRYGVGOWSVROENABMZTOHZRQFUEVPLLIODEYRYLUTOGPYAFHJFIVOSFMPBSHLEKWYWJYTFYETAZQCRFTFHOMACOQVTWKLKYMGIMQDSYNWMFNIEITWMBVVWANBQFVUSKZOTLCCWABAGHWZBZHRDKHDTUOMUUUGQICHNUUQFJYUCQUO"; //1285bytes

	// define Cipher text as an assigned integer(0-25) into a 257*5 matrix
	int C[257][5] = { 0, }; // m=257, d=5
	int tmp = 0;
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			C[i][j] = Cipher[tmp] - 65;
			tmp++;
		}
	}

	// check the input cIpher matrix C
	printf("\n Matrix C \n");
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d  ", C[i][j]);
		}
		printf("\n");
	}
	printf("\n");

	// check if Cipher text transformed correctly
	printf("\n Ciher text \n");
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%c", (char)(C[i][j] + 65));
		}
	}
	printf("\n");


	// 5. set the matrix K_inverse found by Bruteforce way
	int K_inverse[5][5]; // # m = 257, d = 5

	K_inverse[0][0] = 3;
	K_inverse[1][0] = 19;
	K_inverse[2][0] = 11;
	K_inverse[3][0] = 2;
	K_inverse[4][0] = 3;

	K_inverse[0][1] = 17;
	K_inverse[1][1] = 24;
	K_inverse[2][1] = 13;
	K_inverse[3][1] = 11;
	K_inverse[4][1] = 21;

	K_inverse[0][2] = 12;
	K_inverse[1][2] = 18;
	K_inverse[2][2] = 4;
	K_inverse[3][2] = 9;
	K_inverse[4][2] = 0;

	K_inverse[0][3] = 9;
	K_inverse[1][3] = 7;
	K_inverse[2][3] = 12;
	K_inverse[3][3] = 20;
	K_inverse[4][3] = 13;

	K_inverse[0][4] = 18;
	K_inverse[1][4] = 12;
	K_inverse[2][4] = 6;
	K_inverse[3][4] = 16;
	K_inverse[4][4] = 23;

	// print K_inverse
	printf(" \n ---------- K_inverse ---------- \n");
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d  ", K_inverse[i][j]);
		}
		printf("\n");
	}


	// print Plaintext
	printf(" \n ---------- PLAIN TEXT ---------- \n");
	// p = c*k_inverse
	int PLAIN[257][5];
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			PLAIN[i][j] = 0;
			for (int k = 0; k < 5; k++) {
				PLAIN[i][j] += (C[i][k]) * K_inverse[k][j];
			}
			PLAIN[i][j] = (PLAIN[i][j] % 26);
		}
	}


	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%c", (char)(PLAIN[i][j] + 65));
		}
	}

	printf(" \n\n");

	return 0;

}