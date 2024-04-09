PGDMP  2        	            |         (   empresacontrato.com.br/ambiente_stagebus    16.1    16.1 =    )           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            *           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            +           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ,           1262    131480 (   empresacontrato.com.br/ambiente_stagebus    DATABASE     �   CREATE DATABASE "empresacontrato.com.br/ambiente_stagebus" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
 :   DROP DATABASE "empresacontrato.com.br/ambiente_stagebus";
                postgres    false            �            1259    131481    carro    TABLE     �   CREATE TABLE public.carro (
    num_carro integer NOT NULL,
    nome_carro character varying NOT NULL,
    placa_carro character varying NOT NULL,
    tipo_carro integer NOT NULL,
    status_carro integer NOT NULL,
    garagem integer
);
    DROP TABLE public.carro;
       public         heap    postgres    false            �            1259    131486    garagem    TABLE     j  CREATE TABLE public.garagem (
    id_garagem integer NOT NULL,
    nome_garagem character varying NOT NULL,
    largura_garagem double precision NOT NULL,
    comprimento_garagem double precision NOT NULL,
    altura_garagem double precision,
    responsavel_garagem character varying,
    local_garagem character varying,
    quantidade_max integer NOT NULL
);
    DROP TABLE public.garagem;
       public         heap    postgres    false            �            1259    131491    status    TABLE     i   CREATE TABLE public.status (
    id_status integer NOT NULL,
    descricao character varying NOT NULL
);
    DROP TABLE public.status;
       public         heap    postgres    false            �            1259    131496 
   tipo_carro    TABLE     )  CREATE TABLE public.tipo_carro (
    id_tipo_car integer NOT NULL,
    nome_tipo_carro character varying NOT NULL,
    largura_carro double precision NOT NULL,
    comprimento_carro double precision NOT NULL,
    altura_carro double precision NOT NULL,
    peso_carro double precision NOT NULL
);
    DROP TABLE public.tipo_carro;
       public         heap    postgres    false            �            1259    131501    all_cars    VIEW     �  CREATE VIEW public.all_cars AS
 SELECT carro.num_carro,
    carro.nome_carro,
    carro.placa_carro,
    carro.tipo_carro,
    carro.status_carro,
    carro.garagem,
    garagem.nome_garagem,
    status.descricao AS descricao_status,
    tipo_carro.nome_tipo_carro
   FROM (((public.carro
     JOIN public.tipo_carro ON ((carro.tipo_carro = tipo_carro.id_tipo_car)))
     JOIN public.garagem ON ((carro.garagem = garagem.id_garagem)))
     JOIN public.status ON ((carro.status_carro = status.id_status)));
    DROP VIEW public.all_cars;
       public          postgres    false    216    218    218    217    217    216    215    215    215    215    215    215            �            1259    131506    funcionario    TABLE     �   CREATE TABLE public.funcionario (
    id_funcionario integer NOT NULL,
    nome_completo character varying NOT NULL,
    apelido character varying NOT NULL,
    tipo_funcionario integer,
    matricula_funcionario character varying
);
    DROP TABLE public.funcionario;
       public         heap    postgres    false            �            1259    131511    tipo_funcionario    TABLE     y   CREATE TABLE public.tipo_funcionario (
    id_tipo_fun integer NOT NULL,
    descricao_fun character varying NOT NULL
);
 $   DROP TABLE public.tipo_funcionario;
       public         heap    postgres    false            �            1259    131516    all_employee    VIEW     n  CREATE VIEW public.all_employee AS
 SELECT funcionario.id_funcionario,
    funcionario.nome_completo,
    funcionario.apelido,
    funcionario.tipo_funcionario,
    funcionario.matricula_funcionario,
    tipo_funcionario.descricao_fun
   FROM (public.funcionario
     JOIN public.tipo_funcionario ON ((funcionario.tipo_funcionario = tipo_funcionario.id_tipo_fun)));
    DROP VIEW public.all_employee;
       public          postgres    false    221    220    220    220    221    220    220            �            1259    131520    linha    TABLE     �   CREATE TABLE public.linha (
    id_linha integer NOT NULL,
    numero_linha character varying NOT NULL,
    nome_linha character varying NOT NULL,
    roteiro_ida character varying,
    roteiro_volta character varying
);
    DROP TABLE public.linha;
       public         heap    postgres    false            �            1259    131525 	   all_lines    VIEW     �   CREATE VIEW public.all_lines AS
 SELECT id_linha,
    numero_linha,
    nome_linha,
    roteiro_ida,
    roteiro_volta
   FROM public.linha;
    DROP VIEW public.all_lines;
       public          postgres    false    223    223    223    223    223            �            1259    131529    count_max_employee    VIEW     �   CREATE VIEW public.count_max_employee AS
 SELECT ( SELECT count(*) AS count
           FROM public.funcionario) AS count,
    ( SELECT max(funcionario.id_funcionario) AS max
           FROM public.funcionario) AS max;
 %   DROP VIEW public.count_max_employee;
       public          postgres    false    220            �            1259    131533    count_max_garage    VIEW     �   CREATE VIEW public.count_max_garage AS
 SELECT ( SELECT count(*) AS count
           FROM public.garagem) AS count,
    ( SELECT max(garagem.id_garagem) AS max
           FROM public.garagem) AS max;
 #   DROP VIEW public.count_max_garage;
       public          postgres    false    216            �            1259    131537    count_max_line    VIEW     �   CREATE VIEW public.count_max_line AS
 SELECT ( SELECT count(*) AS count
           FROM public.linha) AS count,
    ( SELECT max(linha.id_linha) AS max
           FROM public.linha) AS max;
 !   DROP VIEW public.count_max_line;
       public          postgres    false    223            �            1259    131541    horario    TABLE       CREATE TABLE public.horario (
    id_horario integer NOT NULL,
    dia integer NOT NULL,
    hora time without time zone NOT NULL,
    linha_horario integer NOT NULL,
    carro_horario integer,
    motorista integer,
    cobrador integer,
    garagem_horario integer NOT NULL
);
    DROP TABLE public.horario;
       public         heap    postgres    false            �            1259    131544    count_max_schedule    VIEW     �   CREATE VIEW public.count_max_schedule AS
 SELECT ( SELECT count(*) AS count
           FROM public.horario) AS count,
    ( SELECT max(horario.id_horario) AS max
           FROM public.horario) AS max;
 %   DROP VIEW public.count_max_schedule;
       public          postgres    false    228            �            1259    131548    count_max_type    VIEW     �   CREATE VIEW public.count_max_type AS
 SELECT ( SELECT count(*) AS count
           FROM public.tipo_carro) AS count,
    ( SELECT max(tipo_carro.id_tipo_car) AS max
           FROM public.tipo_carro) AS max;
 !   DROP VIEW public.count_max_type;
       public          postgres    false    218            �            1259    131552    usuario    TABLE     *  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    login_usuario character varying NOT NULL,
    senha_usuario character varying NOT NULL,
    nome_usuario character varying NOT NULL,
    sobrenome_usuario character varying NOT NULL,
    cad_user boolean NOT NULL,
    cad_car boolean NOT NULL,
    cad_gar boolean NOT NULL,
    cad_lin boolean NOT NULL,
    cad_tip_car boolean NOT NULL,
    ed_user boolean NOT NULL,
    ed_car boolean NOT NULL,
    ed_gar boolean NOT NULL,
    ed_lin boolean NOT NULL,
    ed_tip_car boolean NOT NULL,
    em_rel boolean NOT NULL,
    cad_ed_hor boolean NOT NULL,
    perm_user boolean NOT NULL,
    exc_user boolean NOT NULL,
    status_ativo boolean NOT NULL,
    at_des_user boolean NOT NULL,
    cad_fun boolean NOT NULL,
    ed_fun boolean NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    131557    count_max_user    VIEW     �   CREATE VIEW public.count_max_user AS
 SELECT ( SELECT count(*) AS count
           FROM public.usuario) AS count,
    ( SELECT max(usuario.id_usuario) AS max
           FROM public.usuario) AS max;
 !   DROP VIEW public.count_max_user;
       public          postgres    false    231            �            1259    131561    dia    TABLE     g   CREATE TABLE public.dia (
    id_dia integer NOT NULL,
    descricao_dia character varying NOT NULL
);
    DROP TABLE public.dia;
       public         heap    postgres    false            �            1259    131566    log    TABLE     �   CREATE TABLE public.log (
    usuario integer,
    descricao_log character varying NOT NULL,
    data_log date NOT NULL,
    hora_log time without time zone NOT NULL
);
    DROP TABLE public.log;
       public         heap    postgres    false            �            1259    131571    report_bus_day_schedule    VIEW     =  CREATE VIEW public.report_bus_day_schedule AS
 SELECT dia.descricao_dia,
    horario.hora,
    linha.numero_linha,
    horario.carro_horario,
    motorista.apelido AS motorista,
    cobrador.apelido AS cobrador,
    tipo_carro.largura_carro,
    tipo_carro.comprimento_carro,
    horario.garagem_horario,
    horario.dia,
    carro.status_carro
   FROM ((((((public.horario
     JOIN public.carro ON ((horario.carro_horario = carro.num_carro)))
     JOIN public.tipo_carro ON ((carro.tipo_carro = tipo_carro.id_tipo_car)))
     JOIN public.funcionario motorista ON ((horario.motorista = motorista.id_funcionario)))
     JOIN public.funcionario cobrador ON ((cobrador.id_funcionario = horario.cobrador)))
     JOIN public.dia ON ((dia.id_dia = horario.dia)))
     JOIN public.linha ON ((linha.id_linha = horario.linha_horario)));
 *   DROP VIEW public.report_bus_day_schedule;
       public          postgres    false    220    233    233    228    228    228    228    228    228    228    223    223    220    218    218    218    215    215    215            �            1259    131576    report_employee_schedule    VIEW       CREATE VIEW public.report_employee_schedule AS
 SELECT carro.nome_carro,
    linha.nome_linha,
    dia.descricao_dia,
    horario.hora,
    garagem.nome_garagem,
    horario.cobrador,
    horario.motorista,
    horario.dia
   FROM ((((public.horario
     JOIN public.carro ON ((horario.carro_horario = carro.num_carro)))
     JOIN public.linha ON ((horario.linha_horario = linha.id_linha)))
     JOIN public.dia ON ((horario.dia = dia.id_dia)))
     JOIN public.garagem ON ((carro.garagem = garagem.id_garagem)));
 +   DROP VIEW public.report_employee_schedule;
       public          postgres    false    233    228    228    228    228    228    228    223    223    216    216    215    215    215    233            �            1259    131581    report_line_of_car    VIEW     �   CREATE VIEW public.report_line_of_car AS
 SELECT linha.numero_linha,
    horario.hora,
    horario.carro_horario,
    horario.dia
   FROM (public.horario
     JOIN public.linha ON ((linha.id_linha = horario.linha_horario)));
 %   DROP VIEW public.report_line_of_car;
       public          postgres    false    223    228    228    228    228    223            �            1259    131585    report_list_cars_lines    VIEW     \  CREATE VIEW public.report_list_cars_lines AS
 SELECT dia.descricao_dia,
    horario.hora,
    mot.apelido AS nome_motorista,
    cob.apelido AS nome_cobrador,
    garagem.nome_garagem,
    carro.num_carro,
    linha.numero_linha,
    horario.id_horario,
    horario.linha_horario,
    horario.dia,
    horario.carro_horario,
    horario.garagem_horario,
    horario.motorista,
    horario.cobrador
   FROM ((((((public.horario
     JOIN public.dia ON ((horario.dia = dia.id_dia)))
     LEFT JOIN public.funcionario mot ON ((horario.motorista = mot.id_funcionario)))
     LEFT JOIN public.funcionario cob ON ((horario.cobrador = cob.id_funcionario)))
     JOIN public.carro ON ((horario.carro_horario = carro.num_carro)))
     JOIN public.garagem ON ((carro.garagem = garagem.id_garagem)))
     JOIN public.linha ON ((horario.linha_horario = linha.id_linha)));
 )   DROP VIEW public.report_list_cars_lines;
       public          postgres    false    228    233    233    228    228    228    228    228    228    228    223    223    220    220    216    216    215    215            �            1259    131590    report_organize    VIEW     �  CREATE VIEW public.report_organize AS
 SELECT horario.dia,
    horario.hora,
    horario.linha_horario,
    horario.carro_horario AS carro,
    motorista.apelido AS motorista,
    cobrador.apelido AS cobrador,
    horario.garagem_horario,
    carro.num_carro,
    tipo_carro.largura_carro,
    tipo_carro.comprimento_carro
   FROM ((((public.horario
     JOIN public.carro ON ((carro.num_carro = horario.carro_horario)))
     JOIN public.tipo_carro ON ((carro.tipo_carro = tipo_carro.id_tipo_car)))
     JOIN public.funcionario motorista ON ((horario.motorista = motorista.id_funcionario)))
     JOIN public.funcionario cobrador ON ((cobrador.id_funcionario = horario.cobrador)));
 "   DROP VIEW public.report_organize;
       public          postgres    false    215    220    220    218    218    218    215    228    228    228    228    228    228    228                      0    131481    carro 
   TABLE DATA                 public          postgres    false    215   �Z       %          0    131561    dia 
   TABLE DATA                 public          postgres    false    233   �Z                  0    131506    funcionario 
   TABLE DATA                 public          postgres    false    220   I[                 0    131486    garagem 
   TABLE DATA                 public          postgres    false    216   c[       #          0    131541    horario 
   TABLE DATA                 public          postgres    false    228   }[       "          0    131520    linha 
   TABLE DATA                 public          postgres    false    223   �[       &          0    131566    log 
   TABLE DATA                 public          postgres    false    234   �[                 0    131491    status 
   TABLE DATA                 public          postgres    false    217   T\                 0    131496 
   tipo_carro 
   TABLE DATA                 public          postgres    false    218   �\       !          0    131511    tipo_funcionario 
   TABLE DATA                 public          postgres    false    221   	]       $          0    131552    usuario 
   TABLE DATA                 public          postgres    false    231   �]       a           2606    131596    carro carro_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_pkey PRIMARY KEY (num_carro);
 :   ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_pkey;
       public            postgres    false    215            s           2606    131598    dia dia_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.dia
    ADD CONSTRAINT dia_pkey PRIMARY KEY (id_dia);
 6   ALTER TABLE ONLY public.dia DROP CONSTRAINT dia_pkey;
       public            postgres    false    233            i           2606    131600    funcionario funcionario_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    220            c           2606    131602    garagem garagem_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.garagem
    ADD CONSTRAINT garagem_pkey PRIMARY KEY (id_garagem);
 >   ALTER TABLE ONLY public.garagem DROP CONSTRAINT garagem_pkey;
       public            postgres    false    216            o           2606    131604    horario horario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_pkey PRIMARY KEY (id_horario);
 >   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_pkey;
       public            postgres    false    228            m           2606    131606    linha linha_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.linha
    ADD CONSTRAINT linha_pkey PRIMARY KEY (id_linha);
 :   ALTER TABLE ONLY public.linha DROP CONSTRAINT linha_pkey;
       public            postgres    false    223            e           2606    131608    status status_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id_status);
 <   ALTER TABLE ONLY public.status DROP CONSTRAINT status_pkey;
       public            postgres    false    217            k           2606    131610 &   tipo_funcionario tipo_funcionario_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.tipo_funcionario
    ADD CONSTRAINT tipo_funcionario_pkey PRIMARY KEY (id_tipo_fun);
 P   ALTER TABLE ONLY public.tipo_funcionario DROP CONSTRAINT tipo_funcionario_pkey;
       public            postgres    false    221            g           2606    131612    tipo_carro tipo_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.tipo_carro
    ADD CONSTRAINT tipo_pkey PRIMARY KEY (id_tipo_car);
 >   ALTER TABLE ONLY public.tipo_carro DROP CONSTRAINT tipo_pkey;
       public            postgres    false    218            q           2606    131614    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    231            t           2606    131615    carro carro_garagem_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_garagem_fkey FOREIGN KEY (garagem) REFERENCES public.garagem(id_garagem) NOT VALID;
 B   ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_garagem_fkey;
       public          postgres    false    216    4707    215            u           2606    131620    carro carro_status_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_status_fkey FOREIGN KEY (status_carro) REFERENCES public.status(id_status) NOT VALID;
 A   ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_status_fkey;
       public          postgres    false    217    215    4709            v           2606    131625    carro carro_tipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_tipo_fkey FOREIGN KEY (tipo_carro) REFERENCES public.tipo_carro(id_tipo_car) NOT VALID;
 ?   ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_tipo_fkey;
       public          postgres    false    215    218    4711            x           2606    131630    horario horario_carro_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_carro_fk FOREIGN KEY (carro_horario) REFERENCES public.carro(num_carro) NOT VALID;
 B   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_carro_fk;
       public          postgres    false    228    215    4705            y           2606    131635    horario horario_cobrador_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_cobrador_fk FOREIGN KEY (cobrador) REFERENCES public.funcionario(id_funcionario) NOT VALID;
 E   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_cobrador_fk;
       public          postgres    false    220    228    4713            z           2606    131640    horario horario_dia_fk    FK CONSTRAINT     }   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_dia_fk FOREIGN KEY (dia) REFERENCES public.dia(id_dia) NOT VALID;
 @   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_dia_fk;
       public          postgres    false    233    228    4723            {           2606    131645    horario horario_garagem_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_garagem_fk FOREIGN KEY (garagem_horario) REFERENCES public.garagem(id_garagem) NOT VALID;
 D   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_garagem_fk;
       public          postgres    false    4707    228    216            |           2606    131650    horario horario_linha_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_linha_fk FOREIGN KEY (linha_horario) REFERENCES public.linha(id_linha) NOT VALID;
 B   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_linha_fk;
       public          postgres    false    228    4717    223            }           2606    131655    horario horario_motorista_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_motorista_fk FOREIGN KEY (motorista) REFERENCES public.funcionario(id_funcionario) NOT VALID;
 F   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_motorista_fk;
       public          postgres    false    228    4713    220            ~           2606    131660    log log_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_usuario_fkey FOREIGN KEY (usuario) REFERENCES public.usuario(id_usuario) NOT VALID;
 >   ALTER TABLE ONLY public.log DROP CONSTRAINT log_usuario_fkey;
       public          postgres    false    234    4721    231            w           2606    131665    funcionario tipo_fun_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT tipo_fun_fkey FOREIGN KEY (tipo_funcionario) REFERENCES public.tipo_funcionario(id_tipo_fun) NOT VALID;
 C   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT tipo_fun_fkey;
       public          postgres    false    221    4715    220               
   x���          %   �   x���v
Q���W((M��L�K�LTs�	uV�0�QPw����s�W�T��Sp��s��tQp�W��� �Xsy�7�hH��{���#��	q:�N�&@3C�B(0�lP�3��A�� #7:9���.. o݃r          
   x���             
   x���          #   
   x���          "   
   x���          &   �   x���v
Q���W((M��L���OWs�	uV�0�QPOK�R �e�)��+g���&�%��Lt�t�LA<Cs+c+S#uM?g?7O�?�O?wk.O�ZflehAˌ��L����h��	�,32�22�c ����         �   x���v
Q���W((M��L�+.I,)-Vs�	uV�0�QP���W�T��Sp��s��tQp�W�����s���$h��W_��0OGW�3�
T�H�9&@s�](�)�o��~�!�~��7�3�� ��h�         
   x���          !   y   x���v
Q���W((M��L�+�,ȏO+�K���K,��Ws�	uV�0�QP����qT�T��Sp��s��tQp�W�����s���$�L#����NA�.�AT2��LG?����� sVJ�      $   �   x���K�0����_���D�W�<J�RLX����)4p|�n&3�d�,x0@�Q����������� ����W����6��޸��M_�iOe�k3�-�|�"w���N�1,�xN"vt��ػ�u�Gb%�z��l	u�v�T�t��OI����J�P#�5M�F�V/     