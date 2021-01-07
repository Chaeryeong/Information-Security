import java.util.*;
import java.lang.Math.*;


public class kcr_2017320233_prj2 {

	public static void main(String[] args) {
		
		// 1. get 256-bit output Y
		System.out.printf("\n *** Give an 256-bit binary Y in binary:  \n");
		
		//Scanner sc = new Scanner(System.in);
		//String y = sc.nextLine();
		
		String y = "0011001000110000001100010011001000110001001100000011011000110000001100000011001001001011010010110101011101001011010010110101011100110010001100000011000100110010001100010011000000110110001100000011000000110010010010110100101101010111010010110100101101010111";
		System.out.printf(" - given Y: "+y+"\n");
		
		// 2. 2^32 trial to guess A_0 and compute others
			// split into each of 32-bit
		String A_tmp = y.substring(0, 32);
		String B_tmp = y.substring(32, 64);
		String C_tmp = y.substring(64, 96);
		String D_tmp = y.substring(96, 128);
		String E_tmp = y.substring(128, 160);
		String F_tmp = y.substring(160, 192);
		String G_tmp = y.substring(192, 224);
		String H_tmp = y.substring(224);
			// for each guess of A_0 -> B0~H0, T0, W0, A1~B1
		/*for(int A_0=0; A_0<(int)Math.pow(2.0, 32); A_0++) { */ 
			// ** type: long으로 한 후, 2^32 가지 경우의 수에 대해 다 출력해볼 수도 있음.
			// convert long to 32-bit binary A_0
				// 편의를 위해, A_0를 임의 int 가정(2^32 경우의 수 중에 하나로)
			int A_0 = 25767; // decimal, if longer => type long
			String tmp_a = Integer.toBinaryString(A_0);
			String bin_A_0 = String.format("%32s", tmp_a).replaceAll(" ", "0");
			System.out.printf("\n * an arbitrary guessed 32-bit decimal A_0: ");
			System.out.println(A_0+"\n");
			
			// compute B0~H0, T0 through XOR
			int dec_B = Integer.parseInt(B_tmp, 2);
			int B_0 = A_0^dec_B;
			String tmp_b = Integer.toBinaryString(B_0);
			String bin_B_0 = String.format("%32s", tmp_b).replaceAll(" ", "0");
			int dec_C = Integer.parseInt(C_tmp, 2);
			int C_0 = B_0^dec_C;
			String tmp_c = Integer.toBinaryString(C_0);
			String bin_C_0 = String.format("%32s", tmp_c).replaceAll(" ", "0");
			int dec_D = Integer.parseInt(D_tmp, 2);
			int D_0 = C_0^dec_D;
			String tmp_d = Integer.toBinaryString(D_0);
			String bin_D_0 = String.format("%32s", tmp_d).replaceAll(" ", "0");
			int dec_E = Integer.parseInt(E_tmp, 2);
			int E_0 = D_0^dec_E;
			String tmp_e = Integer.toBinaryString(E_0);
			String bin_E_0 = String.format("%32s", tmp_e).replaceAll(" ", "0");
			int dec_F = Integer.parseInt(F_tmp, 2);
			int F_0 = E_0^dec_F;
			String tmp_f = Integer.toBinaryString(F_0);
			String bin_F_0 = String.format("%32s", tmp_f).replaceAll(" ", "0");
			int dec_G = Integer.parseInt(G_tmp, 2);
			int G_0 = F_0^dec_G;
			String tmp_g = Integer.toBinaryString(G_0);
			String bin_G_0 = String.format("%32s", tmp_g).replaceAll(" ", "0");
			int dec_H = Integer.parseInt(H_tmp, 2);
			int H_0 = G_0^dec_H;
			String tmp_h = Integer.toBinaryString(H_0);
			String bin_H_0 = String.format("%32s", tmp_h).replaceAll(" ", "0");
			
			int dec_T = Integer.parseInt(A_tmp, 2);
			int T_0 = dec_T^A_0;
			T_0 = T_0^H_0;
			String tmp_t = Integer.toBinaryString(T_0);
			String bin_T_0 = String.format("%32s", tmp_t).replaceAll(" ", "0");
			
			// print A0~H0, T0
			System.out.printf("  CASE of A_0 to be "+bin_A_0+" in binary: \n");
			System.out.printf("      => A_0: "+ bin_A_0 +" \n");
			System.out.printf("      => B_0: "+ bin_B_0+" \n");
			System.out.printf("      => C_0: "+ bin_C_0+" \n");
			System.out.printf("      => D_0: "+ bin_D_0+" \n");
			System.out.printf("      => E_0: "+ bin_E_0+" \n");
			System.out.printf("      => F_0: "+ bin_F_0+" \n");
			System.out.printf("      => G_0: "+ bin_G_0+" \n");
			System.out.printf("      => H_0: "+ bin_H_0+" \n");
			System.out.printf("      => T_0: "+ bin_T_0+" \n\n");
			
			// compute A1~H1 through XOR
			int A_1 = H_0^T_0;
			String tmp_a_1 = Integer.toBinaryString(A_1);
			String bin_A_1 = String.format("%32s", tmp_a_1).replaceAll(" ", "0");
			int B_1 = A_0;
			String tmp_b_1 = Integer.toBinaryString(B_1);
			String bin_B_1 = String.format("%32s", tmp_b_1).replaceAll(" ", "0");
			int C_1 = B_0;
			String tmp_c_1 = Integer.toBinaryString(C_1);
			String bin_C_1 = String.format("%32s", tmp_c_1).replaceAll(" ", "0");
			int D_1 = C_0;
			String tmp_d_1 = Integer.toBinaryString(D_1);
			String bin_D_1 = String.format("%32s", tmp_d_1).replaceAll(" ", "0");
			int E_1 = D_0;
			String tmp_e_1 = Integer.toBinaryString(E_1);
			String bin_E_1 = String.format("%32s", tmp_e_1).replaceAll(" ", "0");
			int F_1 = E_0;
			String tmp_f_1 = Integer.toBinaryString(F_1);
			String bin_F_1 = String.format("%32s", tmp_f_1).replaceAll(" ", "0");
			int G_1 = F_0;
			String tmp_g_1 = Integer.toBinaryString(G_1);
			String bin_G_1 = String.format("%32s", tmp_g_1).replaceAll(" ", "0");
			int H_1 = G_0;
			String tmp_h_1 = Integer.toBinaryString(H_1);
			String bin_H_1 = String.format("%32s", tmp_h_1).replaceAll(" ", "0");
			
			// print A1~H1 (intermediate values)
			System.out.printf("      => A_1: "+ bin_A_1+" \n");
			System.out.printf("      => B_1: "+ bin_B_1+" \n");
			System.out.printf("      => C_1: "+ bin_C_1+" \n");
			System.out.printf("      => D_1: "+ bin_D_1+" \n");
			System.out.printf("      => E_1: "+ bin_E_1+" \n");
			System.out.printf("      => F_1: "+ bin_F_1+" \n");
			System.out.printf("      => G_1: "+ bin_G_1+" \n");
			System.out.printf("      => H_1: "+ bin_H_1+" \n\n");
			
			// compute W0 through inverse of round function
			String t_0 = bin_T_0.substring(0, 8);
			String t_1 = bin_T_0.substring(8, 16);
			String t_2 = bin_T_0.substring(16, 24);
			String t_3 = bin_T_0.substring(24);
			
			int[][] M_inv = {{0x0e, 0x0b, 0x0d, 0x09},
					  {0x09, 0x0e, 0x0b, 0x0d},
					  {0x0d, 0x09, 0x0e, 0x0b},
					  {0x0b, 0x0d, 0x09, 0x0e}};
			
			int[][] S_inv = {{0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
							 {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
							 {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
							 {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
							 {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
							 {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
							 {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
							 {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
							 {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
							 {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
							 {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
							 {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
							 {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
							 {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
							 {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
							 {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}};
			// 1. G
			// inverse MDS
				// if>256 -> return %256
			String t_0_0 = t_0.substring(0, 2);
			String t_0_1 = t_0.substring(2, 4);
			String t_0_2 = t_0.substring(4, 6);
			String t_0_3 = t_0.substring(6);
			int tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
			tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
			tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
			tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
			tmp_t_0 = tmp_t_0%256;
			
			String t_1_0 = t_1.substring(0, 2);
			String t_1_1 = t_1.substring(2, 4);
			String t_1_2 = t_1.substring(4, 6);
			String t_1_3 = t_1.substring(6);
			int tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
			tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
			tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
			tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
			tmp_t_1 = tmp_t_1%256;
			
			String t_2_0 = t_2.substring(0, 2);
			String t_2_1 = t_2.substring(2, 4);
			String t_2_2 = t_2.substring(4, 6);
			String t_2_3 = t_2.substring(6);
			int tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
			tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
			tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
			tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
			tmp_t_2 = tmp_t_2%256;
			
			String t_3_0 = t_3.substring(0, 2);
			String t_3_1 = t_3.substring(2, 4);
			String t_3_2 = t_3.substring(4, 6);
			String t_3_3 = t_3.substring(6);
			int tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
			tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
			tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
			tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
			tmp_t_3 = tmp_t_3%256;
			
			
			// inverse S
			String S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
			String S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
			String S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
			String S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");
				
				// row: 4-bit msb, col: 4-bit lsb
			int row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
			int col_0 = Integer.parseInt(S_t_0.substring(4), 2);
			int row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
			int col_1 = Integer.parseInt(S_t_1.substring(4), 2);
			int row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
			int col_2 = Integer.parseInt(S_t_2.substring(4), 2);
			int row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
			int col_3 = Integer.parseInt(S_t_3.substring(4), 2);
			
			int S_inv_t0 = S_inv[row_0][col_0];
			int S_inv_t1 = S_inv[row_1][col_1];
			int S_inv_t2 = S_inv[row_2][col_2];
			int S_inv_t3 = S_inv[row_3][col_3];
			
			// XOR with G_0 & update to new binary string t_0, t_1. t_2. t_3
			int G_0_0 = Integer.parseInt(bin_G_0.substring(0, 8), 2);
			int G_0_1 = Integer.parseInt(bin_G_0.substring(8, 16), 2);
			int G_0_2 = Integer.parseInt(bin_G_0.substring(16, 24), 2);
			int G_0_3 = Integer.parseInt(bin_G_0.substring(24), 2);
			
			t_0 = String.format("%8s", Integer.toBinaryString(G_0_0^S_inv_t0)).replaceAll(" ", "0");
			t_1 = String.format("%8s", Integer.toBinaryString(G_0_1^S_inv_t1)).replaceAll(" ", "0");
			t_2 = String.format("%8s", Integer.toBinaryString(G_0_2^S_inv_t2)).replaceAll(" ", "0");
			t_3 = String.format("%8s", Integer.toBinaryString(G_0_3^S_inv_t3)).replaceAll(" ", "0");
			
			
			// 2. F
			// inverse MDS
			// if>256 -> return %256
		t_0_0 = t_0.substring(0, 2);
		t_0_1 = t_0.substring(2, 4);
		t_0_2 = t_0.substring(4, 6);
		t_0_3 = t_0.substring(6);
		tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
		tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
		tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
		tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
		tmp_t_0 = tmp_t_0%256;
		
		t_1_0 = t_1.substring(0, 2);
		t_1_1 = t_1.substring(2, 4);
		t_1_2 = t_1.substring(4, 6);
		t_1_3 = t_1.substring(6);
		tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
		tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
		tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
		tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
		tmp_t_1 = tmp_t_1%256;
		
		t_2_0 = t_2.substring(0, 2);
		t_2_1 = t_2.substring(2, 4);
		t_2_2 = t_2.substring(4, 6);
		t_2_3 = t_2.substring(6);
		tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
		tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
		tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
		tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
		tmp_t_2 = tmp_t_2%256;
		
		t_3_0 = t_3.substring(0, 2);
		t_3_1 = t_3.substring(2, 4);
		t_3_2 = t_3.substring(4, 6);
		t_3_3 = t_3.substring(6);
		tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
		tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
		tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
		tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
		tmp_t_3 = tmp_t_3%256;
		
		// inverse S
		S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
		S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
		S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
		S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");
		
			// row: 4-bit msb, col: 4-bit lsb
		row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
		col_0 = Integer.parseInt(S_t_0.substring(4), 2);
		row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
		col_1 = Integer.parseInt(S_t_1.substring(4), 2);
		row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
		col_2 = Integer.parseInt(S_t_2.substring(4), 2);
		row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
		col_3 = Integer.parseInt(S_t_3.substring(4), 2);
					
		S_inv_t0 = S_inv[row_0][col_0];
		S_inv_t1 = S_inv[row_1][col_1];
		S_inv_t2 = S_inv[row_2][col_2];
		S_inv_t3 = S_inv[row_3][col_3];
					
		// XOR with F_0 & update to new binary string t_0, t_1. t_2. t_3
		int F_0_0 = Integer.parseInt(bin_F_0.substring(0, 8), 2);
		int F_0_1 = Integer.parseInt(bin_F_0.substring(8, 16), 2);
		int F_0_2 = Integer.parseInt(bin_F_0.substring(16, 24), 2);
		int F_0_3 = Integer.parseInt(bin_F_0.substring(24), 2);
					
		t_0 = String.format("%8s", Integer.toBinaryString(F_0_0^S_inv_t0)).replaceAll(" ", "0");
		t_1 = String.format("%8s", Integer.toBinaryString(F_0_1^S_inv_t1)).replaceAll(" ", "0");
		t_2 = String.format("%8s", Integer.toBinaryString(F_0_2^S_inv_t2)).replaceAll(" ", "0");
		t_3 = String.format("%8s", Integer.toBinaryString(F_0_3^S_inv_t3)).replaceAll(" ", "0");	
			
			
			// 3. E
		// inverse MDS
		// if>256 -> return %256
	t_0_0 = t_0.substring(0, 2);
	t_0_1 = t_0.substring(2, 4);
	t_0_2 = t_0.substring(4, 6);
	t_0_3 = t_0.substring(6);
	tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
	tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
	tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
	tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
	tmp_t_0 = tmp_t_0%256;
	
	t_1_0 = t_1.substring(0, 2);
	t_1_1 = t_1.substring(2, 4);
	t_1_2 = t_1.substring(4, 6);
	t_1_3 = t_1.substring(6);
	tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
	tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
	tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
	tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
	tmp_t_1 = tmp_t_1%256;
	
	t_2_0 = t_2.substring(0, 2);
	t_2_1 = t_2.substring(2, 4);
	t_2_2 = t_2.substring(4, 6);
	t_2_3 = t_2.substring(6);
	tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
	tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
	tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
	tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
	tmp_t_2 = tmp_t_2%256;
	
	t_3_0 = t_3.substring(0, 2);
	t_3_1 = t_3.substring(2, 4);
	t_3_2 = t_3.substring(4, 6);
	t_3_3 = t_3.substring(6);
	tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
	tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
	tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
	tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
	tmp_t_3 = tmp_t_3%256;
	
	// inverse S
	S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
	S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
	S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
	S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");
	
		// row: 4-bit msb, col: 4-bit lsb
	row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
	col_0 = Integer.parseInt(S_t_0.substring(4), 2);
	row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
	col_1 = Integer.parseInt(S_t_1.substring(4), 2);
	row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
	col_2 = Integer.parseInt(S_t_2.substring(4), 2);
	row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
	col_3 = Integer.parseInt(S_t_3.substring(4), 2);
				
	S_inv_t0 = S_inv[row_0][col_0];
	S_inv_t1 = S_inv[row_1][col_1];
	S_inv_t2 = S_inv[row_2][col_2];
	S_inv_t3 = S_inv[row_3][col_3];
				
	// XOR with E_0 & update to new binary string t_0, t_1. t_2. t_3
	int E_0_0 = Integer.parseInt(bin_E_0.substring(0, 8), 2);
	int E_0_1 = Integer.parseInt(bin_E_0.substring(8, 16), 2);
	int E_0_2 = Integer.parseInt(bin_E_0.substring(16, 24), 2);
	int E_0_3 = Integer.parseInt(bin_E_0.substring(24), 2);
				
	t_0 = String.format("%8s", Integer.toBinaryString(E_0_0^S_inv_t0)).replaceAll(" ", "0");
	t_1 = String.format("%8s", Integer.toBinaryString(E_0_1^S_inv_t1)).replaceAll(" ", "0");
	t_2 = String.format("%8s", Integer.toBinaryString(E_0_2^S_inv_t2)).replaceAll(" ", "0");
	t_3 = String.format("%8s", Integer.toBinaryString(E_0_3^S_inv_t3)).replaceAll(" ", "0");
		
		
			// 4. D
	// inverse MDS
	// if>256 -> return %256
t_0_0 = t_0.substring(0, 2);
t_0_1 = t_0.substring(2, 4);
t_0_2 = t_0.substring(4, 6);
t_0_3 = t_0.substring(6);
tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
tmp_t_0 = tmp_t_0%256;

t_1_0 = t_1.substring(0, 2);
t_1_1 = t_1.substring(2, 4);
t_1_2 = t_1.substring(4, 6);
t_1_3 = t_1.substring(6);
tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
tmp_t_1 = tmp_t_1%256;

t_2_0 = t_2.substring(0, 2);
t_2_1 = t_2.substring(2, 4);
t_2_2 = t_2.substring(4, 6);
t_2_3 = t_2.substring(6);
tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
tmp_t_2 = tmp_t_2%256;

t_3_0 = t_3.substring(0, 2);
t_3_1 = t_3.substring(2, 4);
t_3_2 = t_3.substring(4, 6);
t_3_3 = t_3.substring(6);
tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
tmp_t_3 = tmp_t_3%256;

// inverse S
S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");

	// row: 4-bit msb, col: 4-bit lsb
row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
col_0 = Integer.parseInt(S_t_0.substring(4), 2);
row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
col_1 = Integer.parseInt(S_t_1.substring(4), 2);
row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
col_2 = Integer.parseInt(S_t_2.substring(4), 2);
row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
col_3 = Integer.parseInt(S_t_3.substring(4), 2);
			
S_inv_t0 = S_inv[row_0][col_0];
S_inv_t1 = S_inv[row_1][col_1];
S_inv_t2 = S_inv[row_2][col_2];
S_inv_t3 = S_inv[row_3][col_3];
			
// XOR with D_0 & update to new binary string t_0, t_1. t_2. t_3
int D_0_0 = Integer.parseInt(bin_D_0.substring(0, 8), 2);
int D_0_1 = Integer.parseInt(bin_D_0.substring(8, 16), 2);
int D_0_2 = Integer.parseInt(bin_D_0.substring(16, 24), 2);
int D_0_3 = Integer.parseInt(bin_D_0.substring(24), 2);
			
t_0 = String.format("%8s", Integer.toBinaryString(D_0_0^S_inv_t0)).replaceAll(" ", "0");
t_1 = String.format("%8s", Integer.toBinaryString(D_0_1^S_inv_t1)).replaceAll(" ", "0");
t_2 = String.format("%8s", Integer.toBinaryString(D_0_2^S_inv_t2)).replaceAll(" ", "0");
t_3 = String.format("%8s", Integer.toBinaryString(D_0_3^S_inv_t3)).replaceAll(" ", "0");
	
	
			// 5. C
// inverse MDS
// if>256 -> return %256
t_0_0 = t_0.substring(0, 2);
t_0_1 = t_0.substring(2, 4);
t_0_2 = t_0.substring(4, 6);
t_0_3 = t_0.substring(6);
tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
tmp_t_0 = tmp_t_0%256;

t_1_0 = t_1.substring(0, 2);
t_1_1 = t_1.substring(2, 4);
t_1_2 = t_1.substring(4, 6);
t_1_3 = t_1.substring(6);
tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
tmp_t_1 = tmp_t_1%256;

t_2_0 = t_2.substring(0, 2);
t_2_1 = t_2.substring(2, 4);
t_2_2 = t_2.substring(4, 6);
t_2_3 = t_2.substring(6);
tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
tmp_t_2 = tmp_t_2%256;

t_3_0 = t_3.substring(0, 2);
t_3_1 = t_3.substring(2, 4);
t_3_2 = t_3.substring(4, 6);
t_3_3 = t_3.substring(6);
tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
tmp_t_3 = tmp_t_3%256;

// inverse S
S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");

// row: 4-bit msb, col: 4-bit lsb
row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
col_0 = Integer.parseInt(S_t_0.substring(4), 2);
row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
col_1 = Integer.parseInt(S_t_1.substring(4), 2);
row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
col_2 = Integer.parseInt(S_t_2.substring(4), 2);
row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
col_3 = Integer.parseInt(S_t_3.substring(4), 2);
		
S_inv_t0 = S_inv[row_0][col_0];
S_inv_t1 = S_inv[row_1][col_1];
S_inv_t2 = S_inv[row_2][col_2];
S_inv_t3 = S_inv[row_3][col_3];
		
// XOR with C_0 & update to new binary string t_0, t_1. t_2. t_3
int C_0_0 = Integer.parseInt(bin_C_0.substring(0, 8), 2);
int C_0_1 = Integer.parseInt(bin_C_0.substring(8, 16), 2);
int C_0_2 = Integer.parseInt(bin_C_0.substring(16, 24), 2);
int C_0_3 = Integer.parseInt(bin_C_0.substring(24), 2);
		
t_0 = String.format("%8s", Integer.toBinaryString(C_0_0^S_inv_t0)).replaceAll(" ", "0");
t_1 = String.format("%8s", Integer.toBinaryString(C_0_1^S_inv_t1)).replaceAll(" ", "0");
t_2 = String.format("%8s", Integer.toBinaryString(C_0_2^S_inv_t2)).replaceAll(" ", "0");
t_3 = String.format("%8s", Integer.toBinaryString(C_0_3^S_inv_t3)).replaceAll(" ", "0");


			// 6. B
// inverse MDS
// if>256 -> return %256
t_0_0 = t_0.substring(0, 2);
t_0_1 = t_0.substring(2, 4);
t_0_2 = t_0.substring(4, 6);
t_0_3 = t_0.substring(6);
tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
tmp_t_0 = tmp_t_0%256;

t_1_0 = t_1.substring(0, 2);
t_1_1 = t_1.substring(2, 4);
t_1_2 = t_1.substring(4, 6);
t_1_3 = t_1.substring(6);
tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
tmp_t_1 = tmp_t_1%256;

t_2_0 = t_2.substring(0, 2);
t_2_1 = t_2.substring(2, 4);
t_2_2 = t_2.substring(4, 6);
t_2_3 = t_2.substring(6);
tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
tmp_t_2 = tmp_t_2%256;

t_3_0 = t_3.substring(0, 2);
t_3_1 = t_3.substring(2, 4);
t_3_2 = t_3.substring(4, 6);
t_3_3 = t_3.substring(6);
tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
tmp_t_3 = tmp_t_3%256;

// inverse S
S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");

// row: 4-bit msb, col: 4-bit lsb
row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
col_0 = Integer.parseInt(S_t_0.substring(4), 2);
row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
col_1 = Integer.parseInt(S_t_1.substring(4), 2);
row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
col_2 = Integer.parseInt(S_t_2.substring(4), 2);
row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
col_3 = Integer.parseInt(S_t_3.substring(4), 2);
		
S_inv_t0 = S_inv[row_0][col_0];
S_inv_t1 = S_inv[row_1][col_1];
S_inv_t2 = S_inv[row_2][col_2];
S_inv_t3 = S_inv[row_3][col_3];
		
// XOR with B_0 & update to new binary string t_0, t_1. t_2. t_3
int B_0_0 = Integer.parseInt(bin_B_0.substring(0, 8), 2);
int B_0_1 = Integer.parseInt(bin_B_0.substring(8, 16), 2);
int B_0_2 = Integer.parseInt(bin_B_0.substring(16, 24), 2);
int B_0_3 = Integer.parseInt(bin_B_0.substring(24), 2);
		
t_0 = String.format("%8s", Integer.toBinaryString(B_0_0^S_inv_t0)).replaceAll(" ", "0");
t_1 = String.format("%8s", Integer.toBinaryString(B_0_1^S_inv_t1)).replaceAll(" ", "0");
t_2 = String.format("%8s", Integer.toBinaryString(B_0_2^S_inv_t2)).replaceAll(" ", "0");
t_3 = String.format("%8s", Integer.toBinaryString(B_0_3^S_inv_t3)).replaceAll(" ", "0");


			// 7. A
// inverse MDS
// if>256 -> return %256
t_0_0 = t_0.substring(0, 2);
t_0_1 = t_0.substring(2, 4);
t_0_2 = t_0.substring(4, 6);
t_0_3 = t_0.substring(6);
tmp_t_0 = M_inv[0][0]*Integer.parseInt(t_0_0,2);
tmp_t_0 = tmp_t_0^(M_inv[0][1]*Integer.parseInt(t_0_1,2));
tmp_t_0 = tmp_t_0^(M_inv[0][2]*Integer.parseInt(t_0_2,2));
tmp_t_0 = tmp_t_0^(M_inv[0][3]*Integer.parseInt(t_0_3,2));
tmp_t_0 = tmp_t_0%256;

t_1_0 = t_1.substring(0, 2);
t_1_1 = t_1.substring(2, 4);
t_1_2 = t_1.substring(4, 6);
t_1_3 = t_1.substring(6);
tmp_t_1 = M_inv[1][0]*Integer.parseInt(t_1_0,2);
tmp_t_1 = tmp_t_1^(M_inv[1][1]*Integer.parseInt(t_1_1,2));
tmp_t_1 = tmp_t_1^(M_inv[1][2]*Integer.parseInt(t_1_2,2));
tmp_t_1 = tmp_t_1^(M_inv[1][3]*Integer.parseInt(t_1_3,2));
tmp_t_1 = tmp_t_1%256;

t_2_0 = t_2.substring(0, 2);
t_2_1 = t_2.substring(2, 4);
t_2_2 = t_2.substring(4, 6);
t_2_3 = t_2.substring(6);
tmp_t_2 = M_inv[2][0]*Integer.parseInt(t_2_0,2);
tmp_t_2 = tmp_t_0^(M_inv[2][1]*Integer.parseInt(t_2_1,2));
tmp_t_2 = tmp_t_0^(M_inv[2][2]*Integer.parseInt(t_2_2,2));
tmp_t_2 = tmp_t_0^(M_inv[2][3]*Integer.parseInt(t_2_3,2));
tmp_t_2 = tmp_t_2%256;

t_3_0 = t_3.substring(0, 2);
t_3_1 = t_3.substring(2, 4);
t_3_2 = t_3.substring(4, 6);
t_3_3 = t_3.substring(6);
tmp_t_3 = M_inv[3][0]*Integer.parseInt(t_3_0,2);
tmp_t_3 = tmp_t_3^(M_inv[3][1]*Integer.parseInt(t_3_1,2));
tmp_t_3 = tmp_t_3^(M_inv[3][2]*Integer.parseInt(t_3_2,2));
tmp_t_3 = tmp_t_3^(M_inv[3][3]*Integer.parseInt(t_3_3,2));
tmp_t_3 = tmp_t_3%256;

// inverse S
S_t_0 = String.format("%8s", Integer.toBinaryString(tmp_t_0)).replaceAll(" ", "0");
S_t_1 = String.format("%8s", Integer.toBinaryString(tmp_t_1)).replaceAll(" ", "0");
S_t_2 = String.format("%8s", Integer.toBinaryString(tmp_t_2)).replaceAll(" ", "0");
S_t_3 = String.format("%8s", Integer.toBinaryString(tmp_t_3)).replaceAll(" ", "0");

// row: 4-bit msb, col: 4-bit lsb
row_0 = Integer.parseInt(S_t_0.substring(0, 4), 2);
col_0 = Integer.parseInt(S_t_0.substring(4), 2);
row_1 = Integer.parseInt(S_t_1.substring(0, 4), 2);
col_1 = Integer.parseInt(S_t_1.substring(4), 2);
row_2 = Integer.parseInt(S_t_2.substring(0, 4), 2);
col_2 = Integer.parseInt(S_t_2.substring(4), 2);
row_3 = Integer.parseInt(S_t_3.substring(0, 4), 2);
col_3 = Integer.parseInt(S_t_3.substring(4), 2);
		
S_inv_t0 = S_inv[row_0][col_0];
S_inv_t1 = S_inv[row_1][col_1];
S_inv_t2 = S_inv[row_2][col_2];
S_inv_t3 = S_inv[row_3][col_3];
		
// XOR with A_0 & update to new binary string t_0, t_1. t_2. t_3
int A_0_0 = Integer.parseInt(bin_A_0.substring(0, 8), 2);
int A_0_1 = Integer.parseInt(bin_A_0.substring(8, 16), 2);
int A_0_2 = Integer.parseInt(bin_A_0.substring(16, 24), 2);
int A_0_3 = Integer.parseInt(bin_A_0.substring(24), 2);
		
String w_0 = String.format("%8s", Integer.toBinaryString(A_0_0^S_inv_t0)).replaceAll(" ", "0");
String w_1 = String.format("%8s", Integer.toBinaryString(A_0_1^S_inv_t1)).replaceAll(" ", "0");
String w_2 = String.format("%8s", Integer.toBinaryString(A_0_2^S_inv_t2)).replaceAll(" ", "0");
String w_3 = String.format("%8s", Integer.toBinaryString(A_0_3^S_inv_t3)).replaceAll(" ", "0");

			
			// print each of it for each A_0
			System.out.printf("      => W_0: "+w_0+w_1+w_2+w_3+" \n");
		//}
	}
	
	
}
