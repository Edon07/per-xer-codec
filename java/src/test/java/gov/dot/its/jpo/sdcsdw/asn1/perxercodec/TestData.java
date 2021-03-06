package gov.dot.its.jpo.sdcsdw.asn1.perxercodec;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.function.Executable;

import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.per.HexPerData;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.per.PerData;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.per.PerDataUnformatter;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.xer.RawXerData;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.xer.XerData;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.xer.XerDataUnformatter;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.PerXerCodec.TypeGuessResult;
import gov.dot.its.jpo.sdcsdw.asn1.perxercodec.exception.CodecFailedException;

/** Repository for sample data
 * 
 * @author amm30955
 *
 */
public class TestData
{
    /** A single test case with PER data
     * 
     * @author amm30955
     *
     * @param <T> Test Data type
     * @param <PerT> PerData type containing the test data
     */
    public static class PerTestDatum<T, PerT extends PerData<T>> 
    {
        /** Create a test case
         *  
         * @param testInput Test data
         * @param unformatter Unformatter for the data
         */
        public PerTestDatum(T testInput,
                            PerDataUnformatter<T, PerT> unformatter)
        {
            super();
            this.testInput = testInput;
            this.unformatter = unformatter;
        }
        
        /** Get the test data 
         * 
         * @return Test data
         */
        public T getTestInput()
        {
            return testInput;
        }
        
        /** Get the unformatter for the test data
         * 
         * @return Unformatter for the test data
         */
        public PerDataUnformatter<T, PerT> getUnformatter()
        {
            return unformatter;
        }
        
        /** Test data */
        private final T testInput;
        /** Unformatter for the data */
        private final PerDataUnformatter<T, PerT> unformatter;
    }
    
    /** A single test case with XER data
     * 
     * @author amm30955
     *
     * @param <T> Test Data type
     * @param <XerT> XerData type containing the test data
     */
    public static class XerTestDatum<T, XerT extends XerData<T>> 
    {
        /** Create a test case
         * 
         * @param testInput Test data
         * @param unformatter Unformatter for the data
         */
        public XerTestDatum(T testInput,
                            XerDataUnformatter<T, XerT> unformatter)
        {
            super();
            this.testInput = testInput;
            this.unformatter = unformatter;
        }
        
        /** Get the test data 
         * 
         * @return Test data
         */
        public T getTestInput()
        {
            return testInput;
        }
        
        /** Get the unformatter for the test data
         * 
         * @return Unformatter for the test data
         */
        public XerDataUnformatter<T, XerT> getUnformatter()
        {
            return unformatter;
        }
        
        /** Test data */
        private final T testInput;
        /** Unformatter for the data */
        private final XerDataUnformatter<T, XerT> unformatter;
    }

    /** Test ASD data */
    public static final PerTestDatum<String, HexPerData> HexPerTestAdvisorySituationData =
            new PerTestDatum<>("444000000006615EC7C0283B90A7148D2B0A89C49F8A85A7763BFB30AF63E2107E160C6F7E210C6F0E00700DA003ED4E020B50DD93846D600000000001EEEBB360603D4E7C8A5A2A72E2D933D3AAAA200007E14B3610002060FF15532F3E9A776741524CD80000010A9C76588E523E43D0BDDC0AF3000508418BE4C2E2A85F1FD71D02F907B8DF17C825C718BE41AE3884300004027BBAECD800",
                    HexPerData.unformatter);
    /** Test Service Request */
    public static final PerTestDatum<String, HexPerData> HexPerTestServiceRequest =
            new PerTestDatum<>("8c 00 00 00 00 1c 0a 9c 43 6b 69 e0",
                    HexPerData.unformatter);
    /** Test Service Response */
    public static final PerTestDatum<String, HexPerData> HexPerTestServiceResponse =
            new PerTestDatum<>("8c 20 00 00 00 1c 0a 9c 43 7f df 86 fb 30 80 08 9a 40 a4 f4 80 54 39 a5 16 fe 22 05 6e 42 20 15 40 f7 b5 af fa aa e6 c7 53 45 3f fd 0a be 84 b6 86 7c f3 e8 fa b9 fa 83 3c 0d 49 39 0e a3 a7 15 16 69 00",
                    HexPerData.unformatter);
    /** Test Data Request for Advisory Data */
    public static final PerTestDatum<String, HexPerData> HexPerTestDataRequest =
            new PerTestDatum<>("0c 40 00 00 00 1c 0a 9c 43 62 93 d2 01 50 e6 94 5b f8 88 15 b9 08 80 55 03 de 04",
                    HexPerData.unformatter);
    /** Test Advisory Data Distribution */
    public static final PerTestDatum<String, HexPerData> HexPerTestAdvisoryDataDistribution = 
            new PerTestDatum<>("19 00 00 00 00 38 15 38 86 c1 c1 20 16 e6 7a 4b a6 00 01 00 06 a3 27 e1 58 07 47 e1 5b 87 4a a0 92 50 38 08 20 12 00 01 f8 11 c2 81 31 37 43 4d 48 56 45 54 30 00 04 00 00 00 00 1f 40 10 01 76 52 1e fd 9d 76 e2 eb ce b4 5a 8c 2f e6 e5 bf 6d 7c bc fa 09 ae cf a9 e7 39 ee 22 21 f4 10 03 80 80 04 00 40 00 d0 c4 47 83 74 00 00 00 a3 26 dc 06 a2 00 28 00 00 00 00 00 00 00 00 00 40 41 60 30 d0 5d 1d 19 5b 9d 1a 5b db 8b 88 15 1a 1a 5c c8 1a 5c c8 18 5b 88 11 5b 59 5c 99 d9 5b 98 de 48 10 5b 19 5c 9d 0b 88 15 1a 19 5c 99 48 1a 5c c8 18 48 1a 18 5e 98 5c 99 1b dd 5c c8 1b 58 5d 19 5c 9a 58 5b 1c c8 1d 1c 9d 58 da c8 1b db 88 19 9a 5c 99 48 18 5a 19 58 59 08 18 5d 08 11 dc 9d 58 98 88 14 dd 1c 99 59 5d 0b 88 11 9b dc 88 1e 5b dd 5c 88 1c d8 59 99 5d 1e 4b 08 1b 58 5a d9 48 18 48 15 4b 5d 1d 5c 9b 88 1b 9b dd cb 0b 08 1b dc 88 1d 1d 5c 9b 88 1b 19 59 9d 08 1b db 88 1c db dd 5d 1a 08 1b 5a 5b 1b 08 1c dd 1c 99 59 5d 08 1d 1b c8 19 5e 1a 5d 08 1d 1a 19 48 18 5c 99 58 4b 81 40 08 00 04 00 1a 8c 9f 85 3e fe 5f 85 4e fe 6a 82 84 c0 e0 20 80 83 80 07 e0 82 8a 00 c4 dd 09 09 59 15 50 c0 c4 00 10 00 00 00 00 7d 00 40 15 d8 7c dc b7 ed af 97 9f 41 15 ea 04 0c ee 0b 0d 4c 3e 82 38 00 10 01 e4 a9 ca 51 53 c3 bb 6a ae c4 66 e5 bf 6c ed fc ba 68 11 5e 8f b4 0e e0 78 10 c3 e8 20 78 02 10 40 91 44 44 04 3a 1e 10 1d 4c 4c 02 f7 02 dc 60 00 00 05 19 36 e0 69 d0 03 40 00 00 00 00 00 00 00 00 02 02 0b 01 8e 82 e8 e8 ca dc e8 d2 de dc 5c 40 a8 d0 d2 e6 40 d2 e6 40 c2 dc 40 8a da ca e4 ce ca dc c6 f2 40 82 d8 ca e4 e8 5c 40 b2 de ea 40 c2 e4 ca 40 c2 e0 e0 e4 de c2 c6 d0 d2 dc ce 40 c2 40 c8 c2 dc ce ca e4 de ea e6 40 ce c2 e6 40 d8 ca c2 d6 40 c2 d0 ca c2 c8 40 de dc 40 a2 ea d2 dc c6 f2 40 a0 d8 c2 c6 ca 5c 40 8c de e4 40 f2 de ea e4 40 e6 c2 cc ca e8 f2 58 40 e8 ea e4 dc 40 d8 ca cc e8 40 c2 e8 40 e8 d0 ca 40 cc d2 e4 e6 e8 40 e6 e8 e4 ca ca e8 40 d2 dc e8 ca e4 e6 ca c6 e8 d2 de dc 40 c2 d0 ca c2 c8 40 c2 dc c8 40 ca f0 d2 e8 40 e8 d0 ca 40 c2 e4 ca c2 40 d2 da da ca c8 d2 c2 e8 ca d8 f2 5c 0b 40 00 00 00 00 00 00 00 00 42 02 0b 01 80 82 e8 e8 ca dc e8 d2 de dc 5c 40 a8 d0 d2 e6 40 d2 e6 40 c2 dc 40 8a da ca e4 ce ca dc c6 f2 40 82 d8 ca e4 e8 5c 40 a8 d0 ca e4 ca 40 d2 e6 40 c2 40 c8 c2 dc ce ca e4 de ea e6 40 ce c2 e6 40 d8 ca c2 d6 40 62 60 60 40 f2 c2 e4 c8 e6 40 e8 de 40 e8 d0 ca 40 e4 d2 ce d0 e8 40 de dc 40 a2 ea d2 dc c6 f2 40 a0 d8 c2 c6 ca 5c 40 8c de e4 40 f2 de ea e4 40 e6 c2 cc ca e8 f2 58 40 c8 de 40 dc de e8 40 e8 ea e4 dc 40 de dc 40 a2 ea d2 dc c6 f2 40 a0 d8 c2 c6 ca 5c 40 86 de dc e8 d2 dc ea ca 40 ce de d2 dc ce 40 e6 e8 e4 c2 d2 ce d0 e8 40 de dc 40 8a c6 d6 d2 dc ce e8 de dc 5c 0a 20 00 10 00 6a 32 7e 15 2d 58 7e 15 65 58 aa 09 85 03 80 82 01 80 00 1f 81 7c 28 03 13 65 f4 44 35 f5 64 55 40 00 40 00 04 f7 41 f4 03 80 17 62 69 d7 83 c3 87 2d f8 71 e8 13 34 53 5d 8f 59 86 36 43 20 2e 00 08 e0 00 00 01 6c 09 a6 50 8b 60 4f 32 84 00 00 00 b0 e3 6e 04 ed 00 14 48 d1 59 e2 44 8d 15 9c 0c 20 20 b0 25 48 2d c4 0d 2d ae 0d ee 4e 8c 2d ce 84 0d ac ae 6e 6c 2c ec a4 0c ce 4d ed a4 0e 8d 0c a4 08 88 64 08 cd 2e 4c a4 08 8c ae 0c 2e 4e 8d ac ad ce 85 c4 0a 8d 0c ae 4c a4 0d 2e 64 0c 24 0d ac 2d 4d ee 44 0c cd 2e 4c a4 0e ed 2e 8d 04 0e 8d ef 0d 2c 64 0e 6d ad ed 6c a4 0c 2e 84 0e 8d 0c a4 0a 0d ee 8d ed ac 2c 64 09 ac ae 8e 4d e4 0a 6e 8c 2e 8d 2d ed c5 c4 0a 0d ee 8c 2d ac 2f 04 0c 2d cc 84 0a 0c ad cd ce 6f 2d 8e cc 2d cd 2c 24 08 2e cc ad ce ac ae 64 0d cc ac 2e 44 0e 8d 0c a4 0e 0d ee 8d ed ac 2c 64 0d ac ae 8e 4d e4 0e 6e 8c 2e 8d 2d ed c4 0c 2e 4c a4 0c 6d 8d ee 6c ac 84 0e 8d e4 0c 2d 8d 84 0e 8e 4c 2c cc cd 2c 65 c4 0a 8d e4 0c 2e cd ed 2c 84 0e 8d 0c a4 0e 6d ad ed 6c a5 84 0c 24 0c 4e 4c ac 2e 8d 0d 2d cc e4 0d 0c 2f 4c 2e 4c 85 84 0f 2d ee a4 0e 6d 0d ee ad 8c 84 0d 0c ac 2c 84 0e 6d ee ae 8d 04 0e 8d ee ec 2e 4c 84 0e 8d 0c a4 08 2d cc 2d ee 6e 8d 2c 24 0a 4d 2e cc ae 45 c0 a0 80 00 40 01 a8 c9 f8 52 2b 75 f8 53 0b 76 a8 21 64 0e 01 58 00 7d 4d 80 00 00 00 c4 dd 11 09 0d 4d 5c c4 c0 00 2c a2 a9 69 1b 1d c2 17 71 88 0a 60 00 91 24 80 7d 00 40 05 d8 da 76 26 a0 89 1a 12 08 74 eb a0 62 c1 45 52 d6 c8 3b 84 2e d9 10 14 04 b0 fc 00 88 40 02 37 28 48 11 b9 02 80 00 06 35 29 00 86 0c 42 84 42 02 00 01 00 06 a3 27 e1 52 d6 27 e1 56 56 2a a0 91 40 38 08 20 10 f0 01 f8 10 b2 80 31 37 44 42 56 45 54 30 32 00 04 00 00 00 00 1f 40 10 01 76 1f 37 2d fb 62 e1 e7 d0 45 52 ff cc 3b 84 68 ef 0f a0 80 1e 04 00 90 ba 1f d5 82 b8 74 02 80 00 00 05 19 36 e0 33 d0 01 40 00 00 00 00 00 00 00 00 02 02 0b 01 7c 82 e8 e8 ca dc e8 d2 de dc 5c 40 a8 d0 d2 e6 40 d2 e6 40 c2 dc 40 8a da ca e4 ce ca dc c6 f2 40 82 d8 ca e4 e8 5c 40 a8 d0 ca e4 ca 40 d2 e6 40 c2 40 d0 c2 f4 c2 e4 c8 de ea e6 40 da c2 e8 ca e4 d2 c2 d8 e6 40 e8 e4 ea c6 d6 40 de dc 40 cc d2 e4 ca 40 c2 e8 40 8c d8 de e4 d2 c8 c2 40 82 ec ca dc ea ca 5c 40 8c de e4 40 f2 de ea e4 40 e6 c2 cc ca e8 f2 58 40 da c2 d6 ca 40 c2 40 aa 5a e8 ea e4 dc 40 dc de ee 58 58 40 de e4 40 e8 ea e4 dc 40 d8 ca cc e8 40 de dc 40 90 c2 e4 e4 f2 40 a8 d0 de da c2 e6 40 ee c2 f2 40 e8 de 40 ca f0 d2 e8 40 e8 d0 ca 40 c2 e4 ca c2 5c 0a 08 00 04 00 1a 8c 9f 86 b9 1a 1f 86 cb 1a 2a 82 21 00 e0 20 60 00 07 df 48 04 c4 dd 11 09 5d 5d 14 c0 c0 00 1c 22 a9 62 36 1d c3 fe 37 00 0c 10 00 00 7d 00 e0 01 f8 45 52 c4 6c 3b 87 fc 6e 0f a0 80 7e 00 26 20 96 89 51 87 b9 f7 a3 3a 63 f2 86 50 07 b6 90 6e 77 db 06 0b 47 eb 08 7f de 68 22 dd a9 84 7e b3 60 9c 36 86 23 e7 5a 80 9a 04 62 11 c4 5f c2 7d 09 68 53 78 fe 0a 50 03 42 5a 90 9b 1b 21 06 80 16 20 13 04 ee c3 28 28 7a 25 e0 00 00 03 80 a0 00 10 00 6a 32 7e 14 b8 1f 7e 14 f0 1f aa 09 1f 03 80 82 01 1a 00 1f 81 16 28 13 13 74 44 35 64 55 43 03 10 00 40 00 00 00 01 f4 01 00 17 62 00 66 e5 bf 6d 7c bc fa 09 9a cc 70 a7 ac 67 3f c1 f4 11 c0 00 80 15 40 ab fe 08 a9 a2 5f f7 c0 00 00 0a 32 6d c0 6c 20 02 80 00 00 00 00 00 00 00 00 04 04 16 03 1d 05 d1 d1 95 b9 d1 a5 bd b8 b8 81 51 a1 a5 cc 81 a5 cc 81 85 b8 81 15 b5 95 c9 9d 95 b9 8d e4 81 05 b1 95 c9 d0 b8 81 65 bd d4 81 85 c9 94 81 85 c1 c1 c9 bd 85 8d a1 a5 b9 9c 81 84 81 91 85 b9 9d 95 c9 bd d5 cc 81 9d 85 cc 81 b1 95 85 ac 81 85 a1 95 85 90 81 bd b8 81 45 d5 a5 b9 8d e4 81 41 b1 85 8d 94 b8 81 19 bd c8 81 e5 bd d5 c8 81 cd 85 99 95 d1 e4 b0 81 d1 d5 c9 b8 81 b1 95 99 d0 81 85 d0 81 d1 a1 94 81 99 a5 c9 cd d0 81 cd d1 c9 95 95 d0 81 a5 b9 d1 95 c9 cd 95 8d d1 a5 bd b8 81 85 a1 95 85 90 81 85 b9 90 81 95 e1 a5 d0 81 d1 a1 94 81 85 c9 95 84 81 a5 b5 b5 95 91 a5 85 d1 95 b1 e4 b8 14 00 80 00 40 01 a8 c9 f8 6b b3 01 f8 6c d3 02 a8 20 71 51 a1 a5 cc 81 a5 cc 81 85 b8 81 85 91 d9 a5 cd bd c9 e4 81 b5 95 cd cd 85 9d 94 ba 00 01 00 06 a3 27 e1 48 c8 47 e1 4c 48 4a a0 85 f0 38 05 c0 01 f5 96 00 00 00 03 13 74 75 64 35 35 73 03 10 00 b2 8e 9d 43 90 74 71 b9 5e 20 28 e0 00 44 7b 81 f4 01 00 17 63 29 d8 9a 82 3d 64 10 e9 d7 40 c1 8a 8e 9d d5 08 74 72 80 32 20 3c 09 61 f0 01 10 81 17 d9 a6 b0 20 af ca b0 59 05 36 89 93 30 00 00 63 52 a0 08 60 c4 a0 44 20 08 00 04 00 1a 8c 9f 86 bb 30 5f 86 cd 30 6a 82 07 15 1a 1a 5c c8 1a 5c c8 18 5b 88 18 59 1d 9a 5c db dc 9e 48 1b 59 5c dc d8 59 d9 4b 81 5b 99 e9 2e 38 00 04 00 1a 8c 9f 85 30 31 5f 85 3e 31 6a 82 45 80 e0 20 80 44 40 07 e0 43 4a 04 c4 dd 11 0d 59 15 50 c0 c8 00 10 00 00 00 00 7d 00 40 05 d8 8c dc b7 ed 9d bf 97 4d 02 66 b3 d5 41 eb 1e f5 88 7d 04 07 00 20 04 da a8 74 8c 27 1e 64 cd 40 00 00 02 8c 9b 70 19 e8 00 a0 00 00 00 00 00 00 00 00 01 01 05 80 be 41 74 74 65 6e 74 69 6f 6e 2e 20 54 68 69 73 20 69 73 20 61 6e 20 45 6d 65 72 67 65 6e 63 79 20 41 6c 65 72 74 2e 20 54 68 65 72 65 20 69 73 20 61 20 68 61 7a 61 72 64 6f 75 73 20 6d 61 74 65 72 69 61 6c 73 20 74 72 75 63 6b 20 6f 6e 20 66 69 72 65 20 61 74 20 46 6c 6f 72 69 64 61 20 41 76 65 6e 75 65 2e 20 46 6f 72 20 79 6f 75 72 20 73 61 66 65 74 79 2c 20 6d 61 6b 65 20 61 20 55 2d 74 75 72 6e 20 6e 6f 77 2c 2c 20 6f 72 20 74 75 72 6e 20 6c 65 66 74 20 6f 6e 20 48 61 72 72 79 20 54 68 6f 6d 61 73 20 77 61 79 20 74 6f 20 65 78 69 74 20 74 68 65 20 61 72 65 61 2e 05 00 20 00 10 00 6a 32 7e 1a ec c0 7e 1b 34 c0 aa 08 1c 54 68 69 73 20 69 73 20 61 6e 20 61 64 76 69 73 6f 72 79 20 6d 65 73 73 61 67 65 2e 80 00 40 01 a8 c9 f8 6b b3 01 f8 6c d3 02 a8 20 71 51 a1 a5 cc 81 a5 cc 81 85 b8 81 85 91 d9 a5 cd bd c9 e4 81 b5 95 cd cd 85 9d 94 ba 00 01 00 06 a3 27 e1 9c c2 67 e1 a0 c2 6a a0 92 50 38 08 20 12 00 01 f8 11 c2 81 31 37 43 4d 48 56 45 54 31 00 04 00 00 00 00 1f 40 10 01 76 52 1e fd 9d 76 e2 eb ce b4 5a 8c 6f e6 e5 bf 6d 7c bc fa 09 af b0 de c7 39 1a 6d 81 f4 10 01 c0 80 04 00 40 00 d4 3b 88 21 08 00 00 00 a3 26 dc 06 a2 00 28 00 00 00 00 00 00 00 00 00 40 41 60 30 d0 5d 1d 19 5b 9d 1a 5b db 8b 88 15 1a 1a 5c c8 1a 5c c8 18 5b 88 11 5b 59 5c 99 d9 5b 98 de 48 10 5b 19 5c 9d 0b 88 15 1a 19 5c 99 48 1a 5c c8 18 48 1a 18 5e 98 5c 99 1b dd 5c c8 1b 58 5d 19 5c 9a 58 5b 1c c8 1d 1c 9d 58 da c8 1b db 88 19 9a 5c 99 48 18 5a 19 58 59 08 18 5d 08 11 dc 9d 58 98 88 14 dd 1c 99 59 5d 0b 88 11 9b dc 88 1e 5b dd 5c 88 1c d8 59 99 5d 1e 4b 08 1b 58 5a d9 48 18 48 15 4b 5d 1d 5c 9b 88 1b 9b dd cb 0b 08 1b dc 88 1d 1d 5c 9b 88 1b 19 59 9d 08 1b db 88 1c db dd 5d 1a 08 1b 5a 5b 1b 08 1c dd 1c 99 59 5d 08 1d 1b c8 19 5e 1a 5d 08 1d 1a 19 48 18 5c 99 58 4b 81 40 00",
                               HexPerData.unformatter);
    /** Test Data Acceptance */
    public static final PerTestDatum<String, HexPerData> HexPerTestDataAcceptance =
            new PerTestDatum<>("19 40 00 00 00 38 15 38 86 c0",
                    HexPerData.unformatter);
    /** Test Data Receipt */
    public static final PerTestDatum<String, HexPerData> HexPerTestDataReceipt = 
            new PerTestDatum<>("19 80 00 00 00 38 15 38 86 c0",
                    HexPerData.unformatter);

    
    
    public static final XerTestDatum<String, RawXerData> RawXerTestAdvisorySituationData =
            new XerTestDatum<>( "<AdvisorySituationData>"
                                  + "<dialogID><advSitDataDep/></dialogID>"
                                  + "<seqID><data/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                  + "<serviceRegion>"
                                      + "<nwCorner><lat>0</lat><long>0</long></nwCorner>"
                                      + "<seCorner><lat>0</lat><long>0</long></seCorner>"
                                  + "</serviceRegion>"
                                  + "<asdmDetails>"
                                      + "<asdmID>00000000</asdmID>"
                                      + "<asdmType><tim/></asdmType>"
                                      + "<distType>10</distType>"
                                      + "<advisoryMessage>00</advisoryMessage>"
                                  + "</asdmDetails>"
                                  + "</AdvisorySituationData>",
                              RawXerData.unformatter);
    
    public static final XerTestDatum<String, RawXerData> RawXerTestServiceRequest =
            new XerTestDatum<>( "<ServiceRequest>"
                                  + "<dialogID><advSitDatDist/></dialogID>"
                                  + "<seqID><svcReq/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                + "</ServiceRequest>",
                               RawXerData.unformatter);

    
    
    public static final XerTestDatum<String, RawXerData> RawXerTestServiceResponse =
            new XerTestDatum<>( "<ServiceResponse>"
                                  + "<dialogID><advSitDatDist/></dialogID>"
                                  + "<seqID><svcResp/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                  + "<expiration></expiration>"
                                  + "<hash>0000000000000000000000000000000000000000000000000000000000000000</hash>"
                                + "</ServiceResponse>",
                               RawXerData.unformatter);
    
    public static final XerTestDatum<String, RawXerData> RawXerTestDataRequest =
            new XerTestDatum<>( "<DataRequest>"
                                  + "<dialogID><advSitDatDist/></dialogID>"
                                  + "<seqID><dataReq/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                  + "<serviceRegion>"
                                      + "<nwCorner>"
                                          + "<lat>0</lat>"
                                          + "<long>0</long>"
                                      + "</nwCorner>"
                                      + "<seCorner>"
                                          + "<lat>0</lat>"
                                          + "<long>0</long>"
                                      + "</seCorner>"
                                  + "</serviceRegion>"
                                  + "<distType>10</distType>"
                                + "</DataRequest>",
                                RawXerData.unformatter);
            
    public static final XerTestDatum<String, RawXerData> RawXerTestDataAcceptance =
            new XerTestDatum<>( "<DataAcceptance>"
                                  + "<dialogID><advSitDatDist/></dialogID>"
                                  + "<seqID><accept/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                + "</DataAcceptance>",
                               RawXerData.unformatter);
    
    public static final XerTestDatum<String, RawXerData> RawXerTestDataReceipt =
            new XerTestDatum<>( "<DataReceipt>"
                                  + "<dialogID><advSitDatDist/></dialogID>"
                                  + "<seqID><receipt/></seqID>"
                                  + "<groupID>00000000</groupID>"
                                  + "<requestID>00000000</requestID>"
                                + "</DataReceipt>",
                               RawXerData.unformatter);
    
    /** Run a PER test case and assert it parses correctly
     * 
     * @param type The type to parse as
     * @param datum The test case to run
     * @throws Exception If anything happens
     */
    public static <T, PerT extends PerData<T>> void assertPerDatumParses(Asn1Type type, PerTestDatum<T, PerT> datum) throws Exception
    {
        Executable exec = () -> PerXerCodec.perToXer(type, datum.getTestInput(), datum.getUnformatter(), RawXerData.formatter);
        assertAll("Expecting to parse as " + type.getName(), exec);
    }
    
    public static <T, PerT extends PerData<T>> void assertPerDatumParsesAs(Iterable<Asn1Type> types, Asn1Type type, PerTestDatum<T, PerT> datum) throws Exception
    {
        TypeGuessResult<String> result = PerXerCodec.guessPerToXer(types, datum.getTestInput(), datum.getUnformatter(), RawXerData.formatter);
        
        assertTrue(result.isSuccesful());
        assertEquals(type, result.getType());
        assertNotNull(result.getData());
    }
    
    /** Run PER test case and assert it fails to parse
     * 
     * @param type The type to parse as
     * @param datum The test case to run
     * @throws Exception If anything happens
     */
    public static <T, PerT extends PerData<T>> void assertPerDatumFails(Asn1Type type, PerTestDatum<T, PerT> datum) throws Exception
    {
        Executable exec = () -> PerXerCodec.perToXer(type, datum.getTestInput(), datum.getUnformatter(), RawXerData.formatter);
        Supplier<String> failureMessageBuilder = () -> {
            try {
                String falseXer = PerXerCodec.perToXer(type, datum.getTestInput(), datum.getUnformatter(), RawXerData.formatter);
                return "Expecting not to parse as " + type.getName() + ", but got XER: " + falseXer;
            } catch (Exception e) {
                return "Dark magic has occured, the xer codec is not pure: " + e.getMessage();
            }
        };
        assertThrows(CodecFailedException.class, exec, failureMessageBuilder);
    }
    
    
    
    /** Run a XER test case and assert it parses correctly
     * 
     * @param type The type to parse as
     * @param datum The test case to run
     * @throws Exception If anything happens
     */
    public static <T, XerT extends XerData<T>> void assertXerDatumParses(Asn1Type type, XerTestDatum<T, XerT> datum) throws Exception
    {
        Executable exec = () -> PerXerCodec.xerToPer(type, datum.getTestInput(), datum.getUnformatter(), HexPerData.formatter);
        assertAll("Expecting to parse as " + type.getName(), exec);
    }
    
    public static <T, XerT extends XerData<T>> void assertXerDatumParsesAs(Iterable<Asn1Type> types, Asn1Type type, XerTestDatum<T, XerT> datum) throws Exception
    {
        TypeGuessResult<String> result = PerXerCodec.guessXerToPer(types, datum.getTestInput(), datum.getUnformatter(), HexPerData.formatter);
        
        assertTrue(result.isSuccesful());
        assertEquals(type, result.getType());
        assertNotNull(result.getData());
    }
    
    /** Run XER test case and assert it fails to parse
     * 
     * @param type The type to parse as
     * @param datum The test case to run
     * @throws Exception If anything happens
     */
    public static <T, XerT extends XerData<T>> void assertXerDatumFails(Asn1Type type, XerTestDatum<T, XerT> datum) throws Exception
    {
        Executable exec = () -> PerXerCodec.xerToPer(type, datum.getTestInput(), datum.getUnformatter(), HexPerData.formatter);
        Supplier<String> failureMessageBuilder = () -> {
            try {
                String falseXer = PerXerCodec.xerToPer(type, datum.getTestInput(), datum.getUnformatter(), HexPerData.formatter);
                return "Expecting not to parse as " + type.getName() + ", but got XER: " + falseXer;
            } catch (Exception e) {
                return "Dark magic has occured, the per codec is not pure: " + e.getMessage();
            }
        };
        assertThrows(CodecFailedException.class, exec, failureMessageBuilder);
    }
}
