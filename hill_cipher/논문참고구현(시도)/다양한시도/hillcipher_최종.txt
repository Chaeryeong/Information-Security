# include <stdio.h>
# include <stdlib.h>
# include <time.h>
# include <math.h>

double IML(int[]);

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

	// 2-4. set d[i][t] values
	/*
	int D[257][5];

	for (int t = 0; t < 257; t++) {
		for (int i = 0; i < 5; i++) {

			int mod_sum = 0;
			for (int e = 0; e < t + 1; e++) {
				mod_sum += (C[i][e]);
				mod_sum = mod_sum % 26;
			}
			mod_sum = mod_sum % 26;
			D[i][t] = mod_sum;

		}
	}

	// check the d[i][t] values of matrix D
	printf("\n Matrix D \n");
	for (int i = 0; i < 257; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d  ", D[i][j]);
		}
		printf("\n");
	}
	*/

	// 5. set the matrix K_inverse
	int K_inverse[5][5]; // # m = 257, d = 5
	srand(time(NULL));
	for (int i = 0; i <5; i++) {
		for (int j = 0; j < 5; j++) {
			K_inverse[i][j] = rand() % 26; // random number in the range 0~25
		}
	}

	// check the K_inverse
	printf("\n Initial K_inverse \n");
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d  ", K_inverse[i][j]);
		}
	}

	// 6. set the vector I : I[j] == IML of the jth column of K_inverse
	double I[5] = { 0, };
	for (int i = 0; i < 5; i++) {
		I[i] = -INFINITY; // so that it can be replaced by x below
	}

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

						if (i_0== 0 && i_1 == 0 && i_2 == 0 && i_3 == 0 && i_4 == 0) continue;

						int x[5] = { i_0, i_1, i_2, i_3, i_4 }; // # d = 5

						// 10. counting max number of zeros at the top of x
						/*
						int t = 0;
						if (i_0 == 0) {
							t++;
							if (i_1 == 0) {
								t++;
								if (i_2 == 0) {
									t++;
									if (i_0 == 0) {
										t++;
									}
								}
							}
						}


						// 11-12. update vector P values
						for (int a = 0; a < 257; a++) {
							P[a] = (P[a] + D[a][t]) % 26;
						}
						*/
						for (int a = 0; a < 257; a++) {
							int pc_temp = 0;
							for (int b = 0; b < 5; b++) {
								pc_temp += (C[a][b]) * x[b];
								pc_temp = pc_temp % 26;
							}
							P[a] = pc_temp;
						}
						/*
						for (int a = 0; a < 257; a++) {
							printf(" %d ", P[a]);
						}
						printf("\n\n");
						*/


						// 13. set an iml_x value
						double iml_x = IML(P);
						//printf("<# %d IML> %lf\n", forloopcnt, iml_x);

						// 14. set y : column of K_inverse with the minimum index iml_y = min I
						int y[5];
						int min_index = 0;
						for (int r = 0; r < 5; r++) {
							if (I[r] < I[min_index]) {
								min_index = r;
							}
						}
						for (int s = 0; s < 5; s++) {
							y[s] = K_inverse[s][min_index];
						}

						// 15-17. update the K_inverse columns
							// x not all-zero modulo 2 or 13 conditions
						int condition = 1;
						int count_mod_zero_2 = 0;
						int count_mod_zero_13 = 0;
						int count_temp = 0;
						// QQQQQQ. [2 13] 경우???
						/*
						for (int i = 0; i < d; i++) {
							if (x[i] % 2 == 0) {
								count_mod_zero_2++;
							}
						}
						if (count_mod_zero_2 == d) { condition = 0; }

						for (int i = 0; i < d; i++) {
							if (x[i] % 13 == 0) {
								count_mod_zero_13++;
							}
						}
						if (count_mod_zero_13 == d) { condition = 0; }
						*/

						for (int r = 0; r < 5; r++) {
							if (((x[r] % 2) == 0) || ((x[r] % 13) == 0)) {
								count_temp++;
							}
						}
						if (count_temp == 5) { condition = 0; }


						if ((I[min_index] < iml_x) && (condition == 1)) {
							// replace the column y in K_inverse with x
							for (int w = 0; w < 5; w++) {
								K_inverse[w][min_index] = x[w];
							}
							// replace iml_y in I with iml_x
							I[min_index] = iml_x;

							printf(" \n updating K_inverse \n");
							printf("update <IML> %lf\n", iml_x);
							for (int g = 0; g < 5; g++) {
								for (int f = 0; f < 5; f++) {
									printf(" %d  ", K_inverse[g][f]);
								}
							}

						}
					}
				}
			}

		}
		clock_t end = clock();
		printf("Time: %lf\n", (double)(end - start) / CLOCKS_PER_SEC);
	}

	printf(" \n\n forloop 개수: %d \n", forloopcnt);

	// print K_inverse
	printf(" \n ---------- K_inverse ---------- \n");
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d  ", K_inverse[i][j]);
		}
		printf("\n");
	}

	// print Plaintext guessed
	printf(" \n ---------- PLAIN TEXT ---------- \n");
	// p = c*k_inverse
	int PLAIN[257][5]; // # m = 11, d = 2
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

double IML(int str[]) {

	// compute normalised frequency f_hat QQQQQ.
	int f_hat[26];
	for (int i = 0; i < 26; i++) {
		int cnt = 0;
		for (int j = 0; j < 257; j++) {
			if (str[j] == i) {
				cnt++;
			}
		}
		f_hat[i] = cnt;
	}
	//printf("\n f_hat COUNT = %d\n", f_hat[4]);

	// check whether the sum==1
	/*
	double sum_hat = 0;
	for (int i = 0; i < 26; i++) {
		sum_hat += f_hat[i];
	}
	printf("\n f_hat sum = %lf \n", sum_hat);
	*/

	double f[26] = { 8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2, 6.1, 7,
				   0.2, 0.8, 0.4, 2.4, 6.7, 1.5, 1.9, 0.1, 6,
				   6.3, 9.1, 2.8, 1, 2.4, 0.2, 2, 0.1 };
	// normalising
	for (int i = 0; i < 26; i++) {
		f[i] = (double)(f[i] / 90.7);
	}

	// check whether the sum==1
	/*
	double sum_f = 0;
	for (int i = 0; i < 26; i++) {
		sum_f += f[i];
	}
	printf("\n f sum = %lf \n", sum_f);
	*/

	double iml_value = 0;


	for (int i = 0; i < 26; i++) {
		iml_value = -(iml_value + ((double)(f_hat[i]/257.0) * log2(f[i]))); // sum of f_hat*log2(f)
	}

	/*
	for (int i = 0; i < m; i++) {
		iml_value = iml_value + (f_hat[str[i]] * log2(f[str[i]])); // sum of f_hat*log2(f)
	}
	*/

	//iml_value = -iml_value;

	return iml_value;
}
