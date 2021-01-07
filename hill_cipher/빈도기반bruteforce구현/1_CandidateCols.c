# include <stdio.h>
# include <stdlib.h>
# include <time.h>
# include <math.h>

int main() {

	// divide and conquer attack on Hill in O(d*26^d)
		// input: ciphertext C of length n = m*d, key size = d*d
		// output: representative decryption matrix K_inverse

	// 1. give inputs
	char Cipher[] = "HRDKHUBHAAMAEQMTMZSHGBAKFUBHAASYRXUNKYUAATQCTLUTOGEWVAJGVEIIYTKIOTQRXXQVSQLISVVOCNGCUXPKPIUBOHTVKCFKWNJSEZYSSUTUOESIXKAPVFXNZHAOQTLCGYJVAEHLNNKEESQMKSHKKDFCNZSRHRDKHSDKFXVPTGMKRUPZBIKEVNYEKXMFXKFYMWYUDZDENEWNKDAOUXGPCXZDLCSNFGCMCSNUAOJDBLQTAHEWYZCHQJYKSNUWOKQKONZGOKDXGUXKEMWQMCFGUEAVKHDIIATCHVTGYMGKJMLNPCNAYKMIRWEETIYQKELEGLQOVKISFNUDAJQIQYBXQTMZSHGBAKFZRCNWRSODAFKKXWGAZGDBIUDDHCUDFRFOVSZXADSHYSGLTQBMNEMKDCFSOZSRDYLIHIAXCMGMFEIDNZKOVJEOIEFNWWQEDRLZYZIZXADSHYSGLJYFWDUAKSIOGOZOXWYPBUFEPNBIRJUJNDZJJYMURKNCIKPWLRMRIAGVSXTYNIWPROHLDHQOMBEKZURQCLQOVKISFNUAFQBHGPCLHZTPJVPXIZKLQSNVKIJAEITTNVSVWNFYVATDEMKDCTGIHKZTVGZYXTYQEDBACFMNCAHRDKHSDKFXZXXGMJOSLPSZBMOILMMWRALAFFMNXXDYFBIYQVVOHSWKGBIRJGTBYQLKIJAEQBTAXGFGAVUIJADHQKLFWRJXYFVIGGQZNBHSUIYOZALSKIABLWQNXNXKOAJAIKHXODXWORVDOGBMHOPLQJZALQJZALIKTKLENZHQAVYUEUFEVLUXHGOWNMGWXUIAHGQOMNCKFQLIPBNKVWDLNGMJCOBFKIGBYWPAHMMPQLUTOGECXITZVVAJEOIDCNWMFNLOBGQXCYFWQFWVXWRKWYGBFHJVLBAWBOUQEKHZHSZZIZARYITDCLQFPGBTJMQVSQLIHPEJONCYMZWTVJVZOBOMOHPSXMPUKVAGXIPOQUQUQBCKXZJSZAHEWYHAEMKOJCCCFBEUKVNCAWANSNXISVVOWHQGQFBGWKQEGBIFRGIZUJQWIMFANTGBHWGVAGXIPOQUQTTRMWDHDGRFENKYPZVCLNQAUBTZSRYGVGOWSVROENABMZTOHZRQFUEVPLLIODEYRYLUTOGPYAFHJFIVOSFMPBSHLEKWYWJYTFYETAZQCRFTFHOMACOQVTWKLKYMGIMQDSYNWMFNIEITWMBVVWANBQFVUSKZOTLCCWABAGHWZBZHRDKHDTUOMUUUGQICHNUUQFJYUCQUO"; //1285bytes
	//int m = 257;
	//int d = 5;
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

	printf("\n Ciher text \n");
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%c", (char)(C[i][j] + 65));
		}
	}
	printf("\n");

	// 7-8. set the vector P : P[i] == decrypted letter of C[i] using an all zero guess for a column of K_inverse
	int P[257] = { 0, };

	// 9-17. find out the columns of K_inverse
	int forloopcnt = 0;
	for (int i_0 = 0; i_0 < 26; i_0++) {
		clock_t start = clock();
		for (int i_1 = 0; i_1 < 26; i_1++) {
			for (int i_2 = 0; i_2 < 26; i_2++) {
				for (int i_3 = 0; i_3 < 26; i_3++) {
					for (int i_4 = 0; i_4 < 26; i_4++) {

						forloopcnt++;
						//printf("<# %d> \n", forloopcnt);

						if (i_0 == 0 && i_1 == 0 && i_2 == 0 && i_3 == 0 && i_4 == 0) continue;

						int x[5] = { i_0, i_1, i_2, i_3, i_4 }; // # d = 5

						for (int a = 0; a < 257; a++) {
							int pc_temp = 0;
							for (int b = 0; b < 5; b++) {
								pc_temp += (C[a][b]) * x[b];
								pc_temp = pc_temp % 26;
							}
							P[a] = pc_temp;
						}

						// print columns that meet the monogram frequency
						int e_cnt = 0;
						int t_cnt = 0;
						int q_cnt = 0;
						int z_cnt = 0;
						int condition = 0;
						for (int ptr = 0; ptr < 257; ptr++) {
							if (P[ptr] == 4) { //e
								e_cnt++;
							}
							if (P[ptr] == 19) { //t
								t_cnt++;
							}
							if (P[ptr] == 16) { //q
								q_cnt++;
							}
							if (P[ptr] == 25) { //z
								z_cnt++;
							}
						}
						if ((e_cnt > 18) && (t_cnt > 17) && (q_cnt < 2) && (z_cnt < 2)) {
							condition = 1;
						}

						// x not all-zero modulo 2 or 13 conditions
						int count_temp = 0;
						for (int r = 0; r < 5; r++) {
							if (((x[r] % 2) == 0) || ((x[r] % 13) == 0)) {
								count_temp++;
							}
						}

						if ((count_temp != 5) && (condition == 1)) {
							printf("candidate column: %d %d %d %d %d\n\n", x[0], x[1], x[2], x[3], x[4]);
						}

					}
				}
			}

		}
		clock_t end = clock();
		printf("Time: %lf\n", (double)(end - start) / CLOCKS_PER_SEC);
	}

	printf(" \n\n forloop 개수: %d \n", forloopcnt);

	return 0;

}