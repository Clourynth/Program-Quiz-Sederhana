/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
 *
 * @author kadek
 */
public class Quiz {

    public static void main(String[] args) {

        // Obyek untuk pilih mode, serius/receh
        Mode mode_permainan = new Mode();

        // Obyek untuk pilih tingkat kesulitan,
        Serius mode_serius = new Serius();
        Receh mode_receh = new Receh();
        Matematika mode_matematika = new Matematika();

        // Obyek program soal dan menjawab
        Soal_serius serius = new Soal_serius();
        Soal_receh receh = new Soal_receh();
        Soal_matematika matematika = new Soal_matematika();

        // Deklarasi. pilihan untuk mode, sedangkan pilihan_kesulitan untuk tingkat kesulitan
        byte pilihan, pilihan_kesulitan;

        boolean mengulang = false;

        System.out.println("Halo, selamat datang di permainan quiz!\n");

        //looping jika pilihan tidak tersedia
        do {
            mode_permainan.pilih_mode();
            pilihan = mode_permainan.get_pilih_mode();

            // mode serius
            switch (pilihan) {
                case 1 -> {
                    System.out.println("Mode serius terpilih\n");
                    do {
                        mode_serius.pilih_kesulitan();
                        pilihan_kesulitan = mode_serius.get_pilih_kesulitan();

                        // tingkat kesulitan mode serius
                        switch (pilihan_kesulitan) {
                            case 1 -> {
                                System.out.println("Kesulitan mudah terpilih\n");
                                serius.gampang();
                                serius.jawab();
                                mengulang = false;
                            }
                            case 2 -> {
                                System.out.println("Kesulitan normal terpilih\n");
                                serius.normal();
                                serius.jawab();
                                mengulang = false;
                            }
                            case 3 -> {
                                System.out.println("Kesulitan sulit terpilih\n");
                                serius.sulit();
                                serius.jawab();
                                mengulang = false;
                            }
                            default -> {
                                System.out.println("Tingkat kesulitan hanya 1/2/3!\n");
                                mengulang = true;
                            }
                        }
                    } while (mengulang == true);
                }
                case 2 -> {
                    System.out.println("Mode receh terpilih\n");
                    do {
                        mode_receh.pilih_kesulitan();
                        pilihan_kesulitan = mode_receh.get_pilih_kesulitan();

                        // tingkat kesulitan mode receh
                        switch (pilihan_kesulitan) {
                            case 1 -> {
                                System.out.println("Kesulitan receh terpilih\n");
                                receh.receh();
                                receh.jawab();
                                mengulang = false;
                            }
                            case 2 -> {
                                System.out.println("Kesulitan garing terpilih\n");
                                receh.garing();
                                receh.jawab();
                                mengulang = false;
                            }
                            case 3 -> {
                                System.out.println("Kesulitan Bapack-bapack terpilih\n");
                                receh.bapack_bapack();
                                receh.jawab();
                                mengulang = false;
                            }
                            default -> {
                                System.out.println("Tingkat kesulitan hanya 1/2/3!\n");
                                mengulang = true;
                            }
                        }
                    } while (mengulang == true);
                }
                case 3 -> {
                    System.out.println("Mode Matematika terpilih\n");
                    do {
                        mode_matematika.pilih_kesulitan();
                        pilihan_kesulitan = mode_matematika.get_pilih_kesulitan();

                        // tingkat kesulitan mode receh
                        switch (pilihan_kesulitan) {
                            case 1 -> {
                                System.out.println("Pertambahan terpilih\n");
                                matematika.pilihSoal(1);
                                mengulang = false;
                            }
                            case 2 -> {
                                System.out.println("Pengurangan terpilih\n");
                                matematika.pilihSoal(2);
                                mengulang = false;
                            }
                            case 3 -> {
                                System.out.println("Perkalian terpilih\n");
                                matematika.pilihSoal(3);
                                mengulang = false;
                            }
                            case 4 -> {
                                System.out.println("Pembagian terpilih\n");
                                matematika.pilihSoal(4);
                                mengulang = false;
                            }
                            case 5 -> {
                                System.out.println("Acak terpilih\n");
                                matematika.pilihSoal(5);
                                mengulang = false;
                            }
                            default -> {
                                System.out.println("Tingkat kesulitan hanya 1/2/3!\n");
                                mengulang = true;
                            }
                        }
                    } while (mengulang == true);
                }
                default -> {
                    System.out.println("Pilihan mode hanya 1/2!\n");
                    mengulang = true;
                }
            }
            // mode receh
        } while (mengulang == true);
    }
}

// class mode, inputan untuk memilih mode.
class Mode {

    Scanner input = new Scanner(System.in);
    byte pilihan;

    public void pilih_mode() {
        System.out.println("Pilih mode permainan yang kamu mau : \n1. Serius\n2. Receh\n3. Matematika");
        System.out.print("Pilihan kamu : ");
        this.pilihan = input.nextByte();
        System.out.println("");
    }

    public byte get_pilih_mode() {
        return pilihan;
    }
}

// class serius, inputan untuk memilih tingkat kesulitan mode serius.
class Serius extends Mode {

    public void pilih_kesulitan() {
        System.out.println("Pilih tingkat kesulitan yang kamu mau : \n1. Gampang\n2. Normal\n3. Sulit");
        System.out.print("Pilihan kamu : ");
        this.pilihan = input.nextByte();
        System.out.println("");
    }

    public byte get_pilih_kesulitan() {
        return pilihan;
    }

}

// program soal serius
class Soal_serius extends Serius {

    ArrayList arraysoal = new ArrayList();
    ArrayList arrayjawaban = new ArrayList();

    int banyaksoal;
    String jawaban;

    public void gampang() {

        // isi soal serius-gampang disini
        arraysoal.add("Siapakah Presiden ke-4 Indonesia ?");
        arraysoal.add("1+2+5+6 =");
        arraysoal.add("Rio senang Ketika temannya sedih. Antonim dari kata ‘sedih’ adalah?");
        arraysoal.add("Ubahlah kalimat -Saya suka makan- kedalam Bahasa ingggis!");
        arraysoal.add("Proses bumi berputar pada porosnya di sebut ?");
        arraysoal.add("Majas yang maknanya melebih-lebihkan situasi disebut ?");
        arraysoal.add("Lagu kebangsaan Indonesia adalah?");
        arraysoal.add("Sumpah pemuda lahir pada tanggal ?");
        arraysoal.add("Budi membeli buku 5 buah dan krisna membeli buku 3 buah. Harga dari satu buah buku ialah 30.000, berapakah total belanjaan budi dan krisna ?");
        arraysoal.add("Ayah pergi ke bandung selama 12 jam perjalanan. Jika 1 jam adalah 60 menit, jadi berapa menit ayah pergi ke bandung?");
        arraysoal.add("Kemampuan organisme untuk meghasilkan keturumam di sebut ?");
        arraysoal.add("Orang yang bisa dipercaya baik perkataan maupun perbuatannya merupakan pengertian dari ?");
        arraysoal.add("Ubahlah kalimat ‘Saya berasal dari indonesia’ kedalam Bahasa ingggis!.");
        arraysoal.add("Siapa pencipta lagu kebangsaan Indonesia ? (Wage Rudolf Soepratman)");
        arraysoal.add("Alif salah menjawab saat ujian. Sinonim dari kata ‘salah’ adalah?");

        // isi jawaban serius-gampang disini
        arrayjawaban.add("abdurrahman wahid");
        arrayjawaban.add("14");
        arrayjawaban.add("senang");
        arrayjawaban.add("i like eat");
        arrayjawaban.add("rotasi bumi");
        arrayjawaban.add("majas hiperbola");
        arrayjawaban.add("indonesia raya");
        arrayjawaban.add("28 oktober");
        arrayjawaban.add("240000");
        arrayjawaban.add("720");
        arrayjawaban.add("reproduksi");
        arrayjawaban.add("jujur");
        arrayjawaban.add("i am from indonesia");
        arrayjawaban.add("wage rudolf soepratman");
        arrayjawaban.add("tidak benar");

    }

    public void normal() {

        // isi soal serius-normal disini
        arraysoal.add("3672 x 34 : 12 =");
        arraysoal.add("Perhatikan angka berikut 5,4,6.7.5.6.5.8,5,5,5.4 modusnya adalah?");
        arraysoal.add("Berapakah jumlah ruang jantung pada katak ?");
        arraysoal.add("UU No.39 tahun 1999 di indonesia mengatur tentang ?");
        arraysoal.add("Berapa kali UUD 1945 di amandemen ?");
        arraysoal.add("Apabila masa jenis benda lebih kecil dari masa jenis air, maka benda akan ?");
        arraysoal.add("Alat kelamin betina pada tumbuhan bunga kembang sepatu di sebut ?");
        arraysoal.add("Provinsi papua memiliki sebuah ibu kota yang bernama ?");
        arraysoal.add("What day comes after Tuesday ?");
        arraysoal.add("What is the past form of the verb -take-?");
        arraysoal.add("Kepanjangan dari ARPANET ialah ? ");
        arraysoal.add("Hasil dari (-12) : 3 +8 x (-5) adalah ? ");
        arraysoal.add("Kepanjangan dari FINA ialah ? ");
        arraysoal.add("Badan yang didirikan dengan tujuan untuk memantau pelaksanaan perjanjian dagang dagang yang telah di sepakati bersama dan mengevaluasi kebijakan perdagangan nasional negara adalah ?");
        arraysoal.add("Gunung Tertinggi di Dunia ialah ? ");

        // isi jawaban serius-normal disini
        arrayjawaban.add("1904");
        arrayjawaban.add("5");
        arrayjawaban.add("tiga ruang");
        arrayjawaban.add("hak asasi manusia");
        arrayjawaban.add("4 kali");
        arrayjawaban.add("terapung");
        arrayjawaban.add("putik");
        arrayjawaban.add("jayapura");
        arrayjawaban.add("wednesday");
        arrayjawaban.add("took");
        arrayjawaban.add("advanced research projects administration");
        arrayjawaban.add("-44");
        arrayjawaban.add("federation internationale de natation amateur");
        arrayjawaban.add("wto");
        arrayjawaban.add("gunung everest");

    }

    public void sulit() {

        // isi soal serius-sulit disini
        arraysoal.add("Pemakaian bor listrik dalam kegiatan penambangan merikan pengubahan energi listrik menjadi energi?");
        arraysoal.add("Panjang jarum menitan dalam sebuah jam adalah 20cm. Jika jarum tersebut bergerak selama 35 menit, maka panjang lintasan yang di lalui jaru, itu adalah ? ");
        arraysoal.add("Kerajaan tertua di indonesia ialah ?");
        arraysoal.add("Unsur logam yang paling ringan ialah ?");
        arraysoal.add("Ilmu yang membahas tentang kemanusian di sebut?");
        arraysoal.add("Lapisan udara diantara 80-100 km diatas permukaan bumi di sebut ?");
        arraysoal.add("Pukulan keras dan menukik dalam olahraga badminton ialah ?");
        arraysoal.add("Sinonim dari kata terorganisasi ialah ?");
        arraysoal.add("Santika ___ an accident when they had been in jakarta. The correct answer is ?");
        arraysoal.add("Perang Dunia pertama terjadi pada tahun ?");
        arraysoal.add("Virus yang memiliki asam ribonukleat disebut virus ?");
        arraysoal.add("Kepanjangan dari OSI adalah ?");
        arraysoal.add("Hukum kekekalan massa dikemukakan oleh ?");
        arraysoal.add("Ibu Kota Russia ialah ?");
        arraysoal.add("Amerika serikat menjatuhkan bom atom di kota Hiroshima pada tanggal ?");

        // isi jawaban serius-sulit disini
        arrayjawaban.add("gerak");
        arrayjawaban.add("73cm");
        arrayjawaban.add("kerajaan kutai");
        arrayjawaban.add("litium");
        arrayjawaban.add("humaniora");
        arrayjawaban.add("homosfer");
        arrayjawaban.add("smash");
        arrayjawaban.add("sistematis");
        arrayjawaban.add("got");
        arrayjawaban.add("1914");
        arrayjawaban.add("rna");
        arrayjawaban.add("open system interconnection");
        arrayjawaban.add("lavoisier");
        arrayjawaban.add("moskow");
        arrayjawaban.add("6 agustus");

    }

    public void jawab() {
        int benar = 0;
        int salah = 0;
        byte batasbawah_soal = 1;
        byte soal_terjawab = 0;
        banyaksoal = arraysoal.size();

        // akan terus melooping jika banyak soal lebih banyak dari 1
        while (banyaksoal > batasbawah_soal) {
            banyaksoal = arraysoal.size();
            int soal_random = ThreadLocalRandom.current().nextInt(0, banyaksoal);
            int simpan_soal = soal_random;
            byte soal_display = (byte) (soal_terjawab + 1);

            System.out.println("Soal ke - " + soal_display + " : \n" + arraysoal.get(soal_random));
            System.out.print("Jawaban kamu : ");
            jawaban = input.nextLine().toLowerCase();

            if (jawaban.equals(arrayjawaban.get(simpan_soal))) {
                System.out.println("\nJawaban kamu benar.\n\n");
                benar++;
            } else {
                System.out.println("\nJawaban kamu salah.\nJawaban yang benar adalah : " + arrayjawaban.get(simpan_soal) + "\n\n");
                salah++;
            }
            arraysoal.remove(simpan_soal);
            arrayjawaban.remove(simpan_soal);
            soal_terjawab++;
        }
        // mencari score
        double score = ((double) 100 / (double) soal_terjawab) * benar;

        System.out.println("Total Benar\t= " + benar);
        System.out.println("Total Salah\t= " + salah);

        //membuat hasil menjadi int / float
        if (score % 2 == 0) {
            System.out.println("Score Anda\t= " + (int) score + " / 100");
        } else {
            System.out.println("Score Anda\t= " + score + " / 100");
        }

    }
}

// class receh, inputan untuk memilih tingkat kesulitan mode receh.
class Receh extends Mode {

    public void pilih_kesulitan() {
        System.out.println("Pilih tingkat kesulitan yang kamu mau : \n1. Receh\n2. Garing\n3. Bapack-Bapack");
        System.out.print("Pilihan kamu : ");
        pilihan = input.nextByte();
        System.out.println("");

    }

    public byte get_pilih_kesulitan() {

        return pilihan;
    }
}

// program soal mode receh
class Soal_receh extends Receh {

    ArrayList arraysoal = new ArrayList();
    ArrayList arrayjawaban = new ArrayList();
    ArrayList arrayketerangan = new ArrayList();

    int banyaksoal;
    String jawaban;

    public void receh() {

        // isi soal receh-receh disini
        arraysoal.add("""
                      Diakuarium ada 10 ikan, mati 2, tinggal...
                      = D _ _ _ _ _ _""");
        arraysoal.add("""
                      Selain bus, mobil, motor, dan pesawat. Orang pergi dari jakarta ke surabaya biasanya menggunakan...
                      = _ E _ _ _ A""");
        arraysoal.add("""
                      Binatang yang suka hinggap dimakanan, binatang...
                      = L A _ A _""");
        arraysoal.add("""
                      Ada domba sebelas ditruck, loncat satu, tinggal...
                      = S E _ _ L _ _""");
        arraysoal.add("""
                      Banteng nyeruduk menggunakan...
                      = T _ N _ _ _""");
        arraysoal.add("""
                      Didalam perpustakaan kita tidak boleh...
                      = _ E R _ _ _ _""");
        arraysoal.add("""
                      Neil Amstrong adalah astronot yang pernah menginjakan kakinya di...
                      = _ U _ A _""");
        arraysoal.add("""
                      Lorenzo, Marquez, Rossi kejar – kerjaran, salip menyalip di...
                      = B _ _ _ _ _ """);
        arraysoal.add("""
                      Setelah lulus SMK/SMA biasanya lanjut...
                      = _ U L _ _ _""");
        arraysoal.add("""
                      Mie Ramen adalah makanan khas yang berasal dari...
                      = _ E _ _ A _""");
        arraysoal.add("""
                      Supaya bersih kita mandi dengan...
                      = _ A _ _ N""");
        arraysoal.add("""
                      Orang berjalan di atas air tidak pakai...
                      = _ _ A _""");
        arraysoal.add("""
                      Yang suka makan pisang?
                      = _ _ N Y _ _""");
        arraysoal.add("""
                      Ikan bernapas dengan...
                      = I _ _ _ _ _ _ _ _""");
        arraysoal.add("""
                      Banteng menyeruduk menggunakan...
                      = T _ N _ _ _""");

        // isi jawaban receh-receh disini
        arrayjawaban.add("dibuang");
        arrayjawaban.add("celana");
        arrayjawaban.add("lapar");
        arrayjawaban.add("sebelas");
        arrayjawaban.add("tenaga");
        arrayjawaban.add("keramas");
        arrayjawaban.add("rumah");
        arrayjawaban.add("biarin");
        arrayjawaban.add("pulang");
        arrayjawaban.add("mentah");
        arrayjawaban.add("yakin");
        arrayjawaban.add("otak");
        arrayjawaban.add("banyak");
        arrayjawaban.add("izintuhan");
        arrayjawaban.add("tenaga");

        // isi keterangan jawaban receh-receh disini
        arrayketerangan.add("ya, kalau ga dibuang nanti ikan yang lain ikut mati coy kasian");
        arrayketerangan.add("nanti kalau gapake celana dikira ODGJ yang kabur xixixi ");
        arrayketerangan.add("kalau galapar dia nyari angin bukan makanan bro ");
        arrayketerangan.add("tetep ada sebelas, men dia loncatnya kan ditruck aja ga keluar truck ");
        arrayketerangan.add("ya masa banteng nyeruduk lemes letoy gapake tenaga bro ");
        arrayketerangan.add("ngapain juga keramas diperpus diusir yang ada nantii ");
        arrayketerangan.add("karena beliau hanya seorang manusia yang perlu tempat tinggal");
        arrayketerangan.add("yaa di biarinnnn masa di hadang wong lagi tanding ");
        arrayketerangan.add("mau kemana emang mas kalo ga pulang? Kalo dah lulus yo pulang dulu ");
        arrayketerangan.add("sebelum jadi ramen mateng kan diolah dulu masih mentahhh xixi ");
        arrayketerangan.add("Mau pake sabun/sampo kalo ngga yakin mending ngga usah mandi");
        arrayketerangan.add("Udah tau ada jalanan kenapa harus jalan di air :)");
        arrayketerangan.add("Ya banyak bro gak cuma monyet yang suka, dari kalian ada yang suka kan?");
        arrayketerangan.add("Kalau gak diizinin gak bisa napas alias ga hidup ehehe");
        arrayketerangan.add("Kalo gapake tenaga mah lemes, kalo lemes bukan nyeruduk namanya awokwkwk");

    }

    public void garing() {

        // isi soal receh-garing disini
        arraysoal.add("""
                      Ada guling ada...
                      = B _ N _ _ _""");
        arraysoal.add("""
                      Ikan bernapas dengan...
                      = _ E _ _ _ A""");
        arraysoal.add("""
                     Burung adalah hewan yang bisa...
                      = T E _ _ _ _ _ """);
        arraysoal.add("""
                      Dunia tak selebar daun...
                      = _ E _ _ _""");
        arraysoal.add("""
                      Seorang dosen PBO dikelas TRPL biasanya dipanggil pak...
                      = _ _ _ _ _ _""");
        arraysoal.add("""
                      Orang kalau minum di...
                      = _ E L A _""");
        arraysoal.add("""
                     Burung bisa terbang karena memiliki...
                      = _ A _ A _ """);
        arraysoal.add("""
                      Seorang barber mencukur rambut pelanggan dengan...
                      = G _ N T _ _ _""");
        arraysoal.add("""
                      Bertamu lebih dari 2x24 jam harus...
                      = _ A _ _ _""");
        arraysoal.add("""
                      Kita tidak bisa menelepon, kalau handphone-nya nggak ada...
                      = _ _ _ _ A""");
        arraysoal.add("""
                      Tanda kalau kucing marah ekornya...
                      = _ A _ _""");
        arraysoal.add("""
                      Hewan yang besar namanya...
                      = G _ _ _ _""");
        arraysoal.add("""
                      Pesawat mendarat di...
                      = B_N_ _ _ _""");
        arraysoal.add("""
                      Sungai yang ada dikalimantan...
                      = _ A _ _ A _""");
        arraysoal.add("""
                      Orang bisa berdiri dengan...
                      = K _ _ _""");

        // isi jawaban receh-garing disini
        arrayjawaban.add("benang");
        arrayjawaban.add("tenang");
        arrayjawaban.add("temenan");
        arrayjawaban.add("betul");
        arrayjawaban.add("nengok");
        arrayjawaban.add("telan");
        arrayjawaban.add("bakat");
        arrayjawaban.add("gantian");
        arrayjawaban.add("makan");
        arrayjawaban.add("angka");
        arrayjawaban.add("satu");
        arrayjawaban.add("gemuk");
        arrayjawaban.add("bantuin");
        arrayjawaban.add("banyak");
        arrayjawaban.add("kuat");

        // isi keterangan jawaban receh-garing disini
        arrayketerangan.add("ya, kalau ga ada benangnya gimana cara jahitnya biar jadi guling? ☹");
        arrayketerangan.add("karna kalau ga tenang oleng nanti mwheheh");
        arrayketerangan.add("semua makhluk hidup kan bisa punya temen gacuma manusia aja bro");
        arrayketerangan.add("ya mana ada daun yang selebar dunia brodiii");
        arrayketerangan.add("kalo ga nengok mungkin manggilnya bu");
        arrayketerangan.add("mau minum tapi masa ga ditelan, yo ditelan pasti tohhh");
        arrayketerangan.add("kalo gada bakat yaa gabisa wak mager dia");
        arrayketerangan.add("kalo ga gantin susah bro mas nya motongnya");
        arrayketerangan.add("pengsannn atuh kalo namu segitu lama tapi ga makan");
        arrayketerangan.add("gimana cara ngetinya dongsss kalo gada angka");
        arrayketerangan.add("Kalau bukan satu namanya bukan kucing");
        arrayketerangan.add("Karena hewan yg badan nya besar pasti gemuk");
        arrayketerangan.add("Ya dibantuin Pilot, co-pilot, operator bandara dll, kalo ngga gimana bisa mendarat :)");
        arrayketerangan.add("Bener kan, banyak? Ada sungai barito,sungai kapuas,sungai kahayan dll");
        arrayketerangan.add("Kalo gakuat gimana bisa berdiri brohhh");

    }

    public void bapack_bapack() {

        // isi soal receh-bapack disini
        arraysoal.add("""
                      Plat nomor kendaraan A berasal dari...
                      = _ A _ _ _ _""");
        arraysoal.add("""
                      Batik merupakan product asli dari...
                      = _ _ _ _ _ I A""");
        arraysoal.add("""
                      Segalak – galaknya harimau pasti ga akan makan...
                      = _ _ _ U _ A _""");
        arraysoal.add("""
                      Unggas berkaki 2 adalah...
                      = B E _ _ _""");
        arraysoal.add("""
                      Kebanyakan orang tidur waktu...
                      = M _ _ _ M""");
        arraysoal.add("""
                     Lawanya gemuk...
                      = _ _ _ U _ """);
        arraysoal.add("""
                      Ada raja, ada ratu, ada pangeran. Jika rajanya meninggal pangeran jadi...
                      = _ A _ _ _ """);
        arraysoal.add("""
                      istri akan merasa terkejut bila di hari ulang tahun dibelikan...
                      = B E R _ _ _ _""");
        arraysoal.add("""
                     Nasi yang enak buat sarapan, biasanya nasi...
                      = _ _ _ _ N G """);
        arraysoal.add("""
                     Koran disebut surat...
                      = _ A _ A _ """);
        arraysoal.add("""
                     Menjelang lebaran kita tidak diwajibkan membeli...
                     = _ A _ U""");
        arraysoal.add("""
                     Kebiasaan apa yang sering dilakukan supir angkot?
                     = _ A _ _ K""");
        arraysoal.add("""
                     Vokalis naif...
                     = D_ _ I _ """);
        arraysoal.add("""
                     Mamat di marahi bu guru karena.....sekolah
                     = B O _ _ _""");
        arraysoal.add("""
                     Sebelum hari senin adalah hari...
                     = _ I _ _ _""");

        // isi jawaban receh-bapack disini
        arrayjawaban.add("samsat");
        arrayjawaban.add("manusia");
        arrayjawaban.add("alpukat");
        arrayjawaban.add("benar");
        arrayjawaban.add("merem");
        arrayjawaban.add("takut");
        arrayjawaban.add("yatim");
        arrayjawaban.add("beruang");
        arrayjawaban.add("mateng");
        arrayjawaban.add("salah");
        arrayjawaban.add("paku");
        arrayjawaban.add("narik");
        arrayjawaban.add("dikit");
        arrayjawaban.add("bobol");
        arrayjawaban.add("libur");

        // isi keterangan jawaban receh-bapack disini
        arrayketerangan.add("hehe kan cuma samsat intuisi yang berhak mengeluarkan plat ");
        arrayketerangan.add("sejauh ini blm ada yang selain buatan manusia ");
        arrayketerangan.add("ga doyan juga si harimau makanya ga dimakan xixixi ");
        arrayketerangan.add("yaaaaa bener, gada yang salah kan bro? ");
        arrayketerangan.add("kalo ga meren bukan tidur namanya wqwq");
        arrayketerangan.add("yaaa takut wak kalo lawanya gemuk xixixi");
        arrayketerangan.add("kalo ratunya yang meninggal jadi piatu");
        arrayketerangan.add("istri mana yang ga kaget dikasi beruang packkk");
        arrayketerangan.add("yaaa kalo ga mateng gimana cara nikmatinya xixixi ");
        arrayketerangan.add("masa koran disebut surat, salah dong");
        arrayketerangan.add("Ngapain juga beli paku mending beli baju");
        arrayketerangan.add("Ya kalo ga narik anak istri makan apa dong xixixi");
        arrayketerangan.add("Setau kita david doang, satu dikit kan?");
        arrayketerangan.add("kalo cuma bolos mah tinggal Alpa in, lah kalo bobol sekolah ya dimarahin ");
        arrayketerangan.add("Bener kan? sebelum senin tu minggu, minggu hari libur kan?");

    }

    // method jawab berfungsi sebagai inputan jawaban, mengacak soal, dan pengecekan jawaban.
    public void jawab() {
        int benar = 0;
        int salah = 0;
        byte batasbawah_soal = 1;
        byte soal_terjawab = 0;
        banyaksoal = arraysoal.size();

        // akan terus melooping jika banyak soal lebih banyak dari 1
        while (banyaksoal > batasbawah_soal) {
            banyaksoal = arraysoal.size();
            int soal_random = ThreadLocalRandom.current().nextInt(0, banyaksoal);
            int simpan_soal = soal_random;
            byte soal_display = (byte) (soal_terjawab + 1);

            System.out.println("Soal ke - " + soal_display + " : \n" + arraysoal.get(soal_random));
            System.out.print("Jawaban kamu : ");
            jawaban = input.nextLine().toLowerCase();

            if (jawaban.equals(arrayjawaban.get(simpan_soal))) {
                System.out.println("\nJawaban kamu benar.");
                System.out.println("Kok gitu? " + arrayketerangan.get(simpan_soal) + "\n\n");
                benar++;
            } else {
                System.out.println("\nJawaban kamu salah.\nJawaban yang benar adalah : " + arrayjawaban.get(simpan_soal));
                System.out.println("Kok gitu? " + arrayketerangan.get(simpan_soal) + "\n\n");
                salah++;
            }
            arraysoal.remove(simpan_soal);
            arrayjawaban.remove(simpan_soal);
            arrayketerangan.remove(simpan_soal);
            soal_terjawab++;
        }
        // mencari score
        double score = ((double) 100 / (double) soal_terjawab) * benar;

        System.out.println("Total Benar\t= " + benar);
        System.out.println("Total Salah\t= " + salah);

        //membuat hasil menjadi int / float
        if (score % 2 == 0) {
            System.out.println("Score Anda\t= " + (int) score + " / 100");
        } else {
            System.out.println("Score Anda\t= " + score + " / 100");
        }

    }
}

class Matematika extends Mode {

    public void pilih_kesulitan() {
        System.out.println("Pilih tingkat kesulitan yang kamu mau : \n1. Pertambahan \n2. Pengurangan \n3. Perkalian \n4. Pembagian \n5. Acak");
        System.out.print("Pilihan kamu : ");
        this.pilihan = input.nextByte();
        System.out.println("");
    }

    public byte get_pilih_kesulitan() {
        return pilihan;
    }
}

class Soal_matematika extends Matematika {

    //Scanner untuk user menginputkan jawaban
    private final Scanner in = new Scanner(System.in);

    //tempat menyimpan angka
    ArrayList arrayangka = new ArrayList();
    //Digunakan untuk memanggil operasi aritmatika

    // membuat jumlah var yang akan oprasikan// //contoh var1+var2+var3//
    private int totalvar;

    //hasil dari operasi
    float sum;

    //boolean digunakan untuk mengembalikan nilai apakah true atau false
    //jia user menjawab benar maka akan mengembalikan true, sebaliknya akan mengembalikan nilai false
    //nlai ini akan digunakan saat menghitung benar dan salah user saat menjawab soal
    @SuppressWarnings("empty-statement")
    boolean soalTambah(int soalke, int jumlahsoal) {
        // variabel untuk menyimpan jawaban user
        float jawaban;
        //memodifikasi tingkat kesulitan berdasarkan soal ke berapa//
        if (soalke >= 0) {
            //pertambahan 2 angka
            totalvar = ThreadLocalRandom.current().nextInt(2, 3);
            //Menyimpan angka random ke dalam arraylist dengan batas max 10//
            for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(1, 10));
            }
            if (soalke >= jumlahsoal / 5) {
                //pengurangan 2 sampai 3 angka
                totalvar = ThreadLocalRandom.current().nextInt(2, 3);
                //Menyimpan angka random ke dalam arraylist dari 10 dengan batas max 25//
                for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                    arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(10, 20));
                }
                if (soalke >= jumlahsoal / 2.5) {
                    //pengurangan 2 sampai 3 angka
                    totalvar = ThreadLocalRandom.current().nextInt(2, 4);
                    //Menyimpan angka random ke dalam arraylistdari 10 dengan batas max 20//
                    for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                        arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(10, 20));
                    }
                    if (soalke >= jumlahsoal / 1.25) {
                        //pengurangan 2 sampai 4 angka
                        totalvar = ThreadLocalRandom.current().nextInt(2, 5);
                        //Menyimpan angka random ke dalam arraylistdari 15 dengan batas max 50//
                        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                            arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(15, 50));
                        }
                    }
                }
            }
        }
        sum = 0;
        System.out.print("Hasil dari penjumlahan ");
        //for ini berfungsi untuk ngeloop angka yang ada di arraylist.
        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
            sum = (float) ((int) arrayangka.get(jumlahAngka) + sum);

            //if ini cuma pake ngeprint soal
            if (jumlahAngka == totalvar - 1) {
                System.out.print(arrayangka.get(jumlahAngka) + " = ");
            } else {
                System.out.print(arrayangka.get(jumlahAngka) + " + ");
            }
        }

        // input jawaban dari user
        jawaban = in.nextFloat();
        //pengecekan jawaban. setelah itu angka di arraylist di remove
        if (jawaban == sum) {
            System.out.println("Jawaban Benar");
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return true;
        } else {
            System.out.println("Jawaban Salah");
            System.out.println("Jawaban yang benar adalah = " + (int) sum);
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return false;
        }
    }

    boolean soalKurang(int soalke, int jumlahsoal) {
        // variabel untuk menyimpan jawaban user
        float jawaban;
        //memodifikasi tingkat kesulitan berdasarkan soal ke berapa//
        if (soalke >= 0) {
            //pertambahan 2 angka
            totalvar = ThreadLocalRandom.current().nextInt(2, 3);
            //Menyimpan angka random ke dalam arraylist dengan batas max 10//
            for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(1, 10));
            }
            if (soalke >= jumlahsoal / 5) {
                //pengurangan 2 sampai 3 angka
                totalvar = ThreadLocalRandom.current().nextInt(2, 3);
                //Menyimpan angka random ke dalam arraylist dari 10 dengan batas max 25//
                for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                    arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(10, 20));
                }
                if (soalke >= jumlahsoal / 2.5) {
                    //pengurangan 2 sampai 3 angka
                    totalvar = ThreadLocalRandom.current().nextInt(2, 4);
                    //Menyimpan angka random ke dalam arraylistdari 10 dengan batas max 20//
                    for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                        arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(10, 20));
                    }
                    if (soalke >= jumlahsoal / 1.25) {
                        //pengurangan 2 sampai 4 angka
                        totalvar = ThreadLocalRandom.current().nextInt(2, 5);
                        //Menyimpan angka random ke dalam arraylistdari 15 dengan batas max 50//
                        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                            arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(15, 50));
                        }
                    }
                }
            }
        }
        sum = 0;
        System.out.print("Hasil dari pengurangan ");
        //ini pake ngeloop angka arraylist
        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
            //ini pake perhitungan minus nya (rumusnya)
            if (jumlahAngka == 0) {
                sum = (float) ((int) arrayangka.get(jumlahAngka) - sum);
            } else {
                sum = sum - (float) ((int) arrayangka.get(jumlahAngka));
            }

            // ini pake ngeprint soal
            if (jumlahAngka == totalvar - 1) {
                System.out.print(arrayangka.get(jumlahAngka) + " = ");
            } else {
                System.out.print(arrayangka.get(jumlahAngka) + " - ");
            }
        }
        // input jawaban dari user
        jawaban = in.nextFloat();

        //pengecekan jawaban. setelah itu angka di arraylist di remove
        if (jawaban == sum) {
            System.out.println("Jawaban Benar");
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return true;
        } else {
            System.out.println("Jawaban Salah");
            System.out.println("Jawaban yang benar adalah = " + (int) sum);
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return false;
        }
    }

    boolean soalKali(int soalke, int jumlahsoal) {
        // variabel untuk menyimpan jawaban user
        float jawaban;
        //memodifikasi tingkat kesulitan berdasarkan soal ke berapa//
        if (soalke >= 0) {
            //pertambahan 2 angka
            totalvar = ThreadLocalRandom.current().nextInt(2, 3);
            //Menyimpan angka random ke dalam arraylist dengan batas max 10//
            for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(3, 6));
            }
            if (soalke >= jumlahsoal / 5) {
                //pengurangan 2 sampai 3 angka
                totalvar = ThreadLocalRandom.current().nextInt(2, 3);
                //Menyimpan angka random ke dalam arraylist dari 10 dengan batas max 25//
                for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                    arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(5, 10));
                }
                if (soalke >= jumlahsoal / 2.5) {
                    //pengurangan 2 sampai 3 angka
                    totalvar = ThreadLocalRandom.current().nextInt(3, 4);
                    //Menyimpan angka random ke dalam arraylistdari 10 dengan batas max 20//
                    for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                        arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(2, 10));
                    }
                    if (soalke >= jumlahsoal / 1.25) {
                        //pengurangan 2 sampai 4 angka
                        totalvar = ThreadLocalRandom.current().nextInt(3, 5);
                        //Menyimpan angka random ke dalam arraylistdari 15 dengan batas max 50//
                        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                            arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(2, 7));
                        }
                    }
                }
            }
        }
        sum = 1;

        //ini pake ngeloop angka arraylist
        System.out.print("Hasil dari perkalian ");
        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
            sum = (float) ((int) arrayangka.get(jumlahAngka) * sum);
            if (jumlahAngka == totalvar - 1) {
                System.out.print(arrayangka.get(jumlahAngka) + " = ");
            } else {
                System.out.print(arrayangka.get(jumlahAngka) + " * ");
            }
        }
        // input jawaban dari user
        jawaban = in.nextFloat();
        //pengecekan jawaban. setelah itu angka di arraylist di remove
        if (jawaban == sum) {
            System.out.println("Jawaban Benar");
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return true;
        } else {
            System.out.println("Jawaban Salah");
            System.out.println("Jawaban yang benar adalah = " + (int) sum);
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return false;
        }
    }

    boolean soalBagi(int soalke, int jumlahsoal) {
        // variabel untuk menyimpan jawaban user
        float jawaban;
        int i;
        //memodifikasi tingkat kesulitan berdasarkan soal ke berapa//
        if (soalke >= 0) {
            i = 0;
            //pertambahan 2 angka
            totalvar = ThreadLocalRandom.current().nextInt(2, 3);
            //Menyimpan angka random ke dalam arraylist dengan batas max 10//
            do {
                i++;
                for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
                    arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(3, 10));
                }
            } while ((int) arrayangka.get(i - 1) > (int) arrayangka.get(i));
//            if (soalke >= jumlahsoal / 5) {
//                i = 0;
//                //pengurangan 2 sampai 3 angka
//                totalvar = ThreadLocalRandom.current().nextInt(2, 3);
//                //Menyimpan angka random ke dalam arraylist dari 10 dengan batas max 25//
//                do {
//                    i++;
//                    for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
//                        arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(5, 15));
//                    }
//                } while ((int) arrayangka.get(i-1) > (int) arrayangka.get(i));
//                if (soalke >= jumlahsoal / 2.5) {
//                    i = 0;
//                    //pengurangan 2 sampai 3 angka
//                    totalvar = ThreadLocalRandom.current().nextInt(2, 4);
//                    //Menyimpan angka random ke dalam arraylistdari 10 dengan batas max 20//
//                    do {
//                        i++;
//                        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
//                            arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(2, 10));
//                        }
//                    } while ((int) arrayangka.get(i-1) > (int) arrayangka.get(i));
//                    if (soalke >= jumlahsoal / 1.25) {
//                        i = 0;
//                        //pengurangan 2 sampai 4 angka
//                        totalvar = ThreadLocalRandom.current().nextInt(2, 5);
//                        //Menyimpan angka random ke dalam arraylistdari 15 dengan batas max 50//
//                        do {
//                            i++;
//                            for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {
//                                arrayangka.add(jumlahAngka, ThreadLocalRandom.current().nextInt(2, 7));
//                            }
//                        } while ((int) arrayangka.get(i-1) > (int) arrayangka.get(i));
//                    }
//                }
//            }
        }
        sum = 1;

        //ini pake ngeloop angka arraylist
        System.out.print("Hasil dari pembagian ");
        for (int jumlahAngka = 0; jumlahAngka < totalvar; jumlahAngka++) {

            //rumus bagi
            if (jumlahAngka == 0) {
                sum = (float) ((int) arrayangka.get(jumlahAngka) / sum);
            } else {
                sum = sum / (float) ((int) arrayangka.get(jumlahAngka));
            }

            //print soal
            if (jumlahAngka == totalvar - 1) {
                System.out.print(arrayangka.get(jumlahAngka) + " = ");
            } else {
                System.out.print(arrayangka.get(jumlahAngka) + " / ");
            }
        }
        // input jawaban dari user
        jawaban = in.nextFloat();

        //pengecekan jawaban. setelah itu angka di arraylist di remove
        if (jawaban == sum) {
            System.out.println("Jawaban Benar");
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return true;
        } else {
            System.out.println("Jawaban Salah");
            System.out.println("Jawaban yang benar adalah = " + (float) sum);
            for (int r = 0; r < totalvar; r++) {
                arrayangka.remove(0);
            }
            return false;
        }
    }

    boolean soalRandom(int soalke, int jumlahsoal) {
        int operasi = ThreadLocalRandom.current().nextInt(1, 5);
        switch (operasi) {
            case 1 -> {
                return soalTambah(soalke, jumlahsoal) == true;

            }
            case 2 -> {
                return soalKurang(soalke, jumlahsoal) == true;

            }
            case 3 -> {
                return soalKali(soalke, jumlahsoal) == true;

            }
            case 4 -> {
                return soalBagi(soalke, jumlahsoal) == true;

            }

        }
        return true;
    }

    void pilihSoal(int pilihan) {
        Soal_matematika a = new Soal_matematika();

        int benar = 0;
        int salah = 0;
        System.out.print("Jumlah soal : ");
        int jumlahsoal = in.nextInt();
        switch (pilihan) {
            case 1 -> {
                for (int i = 0; i < jumlahsoal; i++) {
                    System.out.println("soal " + (i + 1));
                    if (a.soalTambah(i, jumlahsoal) == true) {
                        benar++;
                    } else {
                        salah++;
                    }
                    System.out.println("");
                }
            }
            case 2 -> {
                for (int i = 0; i < jumlahsoal; i++) {
                    System.out.println("soal " + (i + 1));
                    if (a.soalKurang(i, jumlahsoal) == true) {
                        benar++;
                    } else {
                        salah++;
                    }
                    System.out.println("");
                }
            }
            case 3 -> {
                for (int i = 0; i < jumlahsoal; i++) {
                    System.out.println("soal " + (i + 1));
                    if (a.soalKali(i, jumlahsoal) == true) {
                        benar++;
                    } else {
                        salah++;
                    }
                    System.out.println("");
                }
            }
            case 4 -> {
                for (int i = 0; i < jumlahsoal; i++) {
                    System.out.println("soal " + (i + 1));
                    if (a.soalBagi(i, jumlahsoal) == true) {
                        benar++;
                    } else {
                        salah++;
                    }
                    System.out.println("");
                }
            }
            case 5 -> {
                for (int i = 0; i < jumlahsoal; i++) {
                    System.out.println("soal " + (i + 1));
                    if (a.soalRandom(i, jumlahsoal) == true) {
                        benar++;
                    } else {
                        salah++;
                    }
                    System.out.println("");
                }
            }
        }

        System.out.println("Total Soal\t= " + jumlahsoal);
        System.out.println("Total Benar\t= " + benar);
        System.out.println("Total Salah\t= " + salah);

        // mencari score
        double score = ((double) 100 / (double) jumlahsoal) * benar;

        //membuat hasil menjadi int / float
        if (score % 2 == 0) {
            System.out.println("Score Anda\t= " + (int) score + " / 100");
        } else {
            System.out.println("Score Anda\t= " + score + " / 100");
        }
    }
}
