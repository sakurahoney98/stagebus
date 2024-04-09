package com.java.stagebus.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.stagebus.persistence.Conexao;

@SpringBootApplication
public class StagebusApplication {

	private static Conexao conect;
	
	public static void setConexao(String url) {
		conect = new Conexao(url);
		
	}

	public static void main(String[] args) {
		List<String> listObjects = List.of("Nome", "Apelido", "Matricula", "Tipo", "Objeto 5", "Objeto 6", "Objeto 7");

		List<List<String>> twoObjects = new ArrayList<List<String>>();

		List<List<String>> threeObjects = new ArrayList<List<String>>();

		List<List<String>> fourObjects = new ArrayList<List<String>>();
		
		List<List<String>> fiveObjects = new ArrayList<List<String>>();
		
		List<List<String>> sixObjects = new ArrayList<List<String>>();

		for (int i = 0; i < listObjects.size(); i++) {
			String objectPrimary = listObjects.get(i);

			for (int j = 0; j < listObjects.size(); j++) {

				if (listObjects.get(j) != objectPrimary) {
					List<String> temporary = new ArrayList<String>();
					temporary.add(objectPrimary);
					temporary.add(listObjects.get(j));

					boolean insert = false;

					if (twoObjects.isEmpty())
						insert = true;

					for (int k = 0; k < twoObjects.size(); k++) {
						List<String> aux = twoObjects.get(k);
						insert = false;
						for (String element : temporary) {
							if (!aux.contains(element)) {
								insert = true;
								break;
							}

						}
						if (!insert)
							break;
					}

					if (insert)
						twoObjects.add(temporary);

				}
			}

		}

		for (List<String> p : twoObjects) {

			for (String s : p) {
				System.out.println(s);
			}

			System.out.println("------------------------------------------------------------");
		}

		for (int i = 0; i < listObjects.size(); i++) {
			String objectPrimary = listObjects.get(i);

			for (int j = 0; j < listObjects.size(); j++) {
				if (listObjects.get(j) != objectPrimary) {
					String objectSecundary = listObjects.get(j);

					for (int k = 0; k < listObjects.size(); k++) {
						if (listObjects.get(k) != objectPrimary && listObjects.get(k) != objectSecundary) {
							List<String> temporary = new ArrayList<String>();
							temporary.add(objectPrimary);
							temporary.add(objectSecundary);
							temporary.add(listObjects.get(k));

							boolean insert = false;

							if (threeObjects.isEmpty())
								insert = true;

							for (int l = 0; l < threeObjects.size(); l++) {
								List<String> aux = threeObjects.get(l);
								insert = false;
								for (String element : temporary) {
									if (!aux.contains(element)) {
										insert = true;
										break;
									}

								}
								if (!insert)
									break;
							}

							if (insert)
								threeObjects.add(temporary);

						}
					}
				}
			}

		}

		System.out.println("\n\n Três objetos");
		for (List<String> p : threeObjects) {

			for (String s : p) {
				System.out.println(s);
			}

			System.out.println("------------------------------------------------------------");
		}

		for (int i = 0; i < listObjects.size(); i++) {
			String objectPrimary = listObjects.get(i);

			for (int j = 0; j < listObjects.size(); j++) {
				if (listObjects.get(j) != objectPrimary) {
					String objectSecundary = listObjects.get(j);

					for (int k = 0; k < listObjects.size(); k++) {
						if (listObjects.get(k) != objectPrimary && listObjects.get(k) != objectSecundary) {
							String objectTetiary = listObjects.get(k);
							for (int l = 0; l < listObjects.size(); l++) {
								String currentObject = listObjects.get(l);
								if (currentObject != objectPrimary && currentObject != objectSecundary
										&& currentObject != objectTetiary) {
									List<String> temporary = new ArrayList<String>();
									temporary.add(objectPrimary);
									temporary.add(objectSecundary);
									temporary.add(objectTetiary);
									temporary.add(listObjects.get(l));

									boolean insert = false;

									if (fourObjects.isEmpty())
										insert = true;

									for (int m = 0; m < fourObjects.size(); m++) {
										List<String> aux = fourObjects.get(m);
										insert = false;
										for (String element : temporary) {
											if (!aux.contains(element)) {
												insert = true;
												break;
											}

										}
										if (!insert)
											break;
									}

									if (insert)
										fourObjects.add(temporary);
								}
							}

						}
					}
				}
			}

		}

		System.out.println("\n\n Quatro objetos");
		for (List<String> p : fourObjects) {

			for (String s : p) {
				System.out.println(s);
			}

			System.out.println("------------------------------------------------------------");
		}
		
		
		for (int i = 0; i < listObjects.size(); i++) {
			String objectPrimary = listObjects.get(i);

			for (int j = 0; j < listObjects.size(); j++) {
				if (listObjects.get(j) != objectPrimary) {
					String objectSecundary = listObjects.get(j);

					for (int k = 0; k < listObjects.size(); k++) {
						if (listObjects.get(k) != objectPrimary && listObjects.get(k) != objectSecundary) {
							String objectTetiary = listObjects.get(k);
							for (int l = 0; l < listObjects.size(); l++) {
								String currentObject = listObjects.get(l);
								if (currentObject != objectPrimary && currentObject != objectSecundary
										&& currentObject != objectTetiary) {
									String quaternaryObject = listObjects.get(l);
								for(int m = 0; m < listObjects.size(); m++) {
									currentObject = listObjects.get(m);
									if(currentObject != objectPrimary && currentObject != objectSecundary && currentObject != objectTetiary && currentObject != quaternaryObject) {
										List<String> temporary = new ArrayList<String>();
										temporary.add(objectPrimary);
										temporary.add(objectSecundary);
										temporary.add(objectTetiary);
										temporary.add(quaternaryObject);
										temporary.add(listObjects.get(m));

										boolean insert = false;

										if (fiveObjects.isEmpty())
											insert = true;

										for (int n = 0; n < fiveObjects.size(); n++) {
											List<String> aux = fiveObjects.get(n);
											insert = false;
											for (String element : temporary) {
												if (!aux.contains(element)) {
													insert = true;
													break;
												}

											}
											if (!insert)
												break;
										}

										if (insert)
											fiveObjects.add(temporary);
									}
								}
								}
							}

						}
					}
				}
			}

		}
		
		System.out.println("\n\n Cinco objetos");
		for (List<String> p : fiveObjects) {

			for (String s : p) {
				System.out.println(s);
			}

			System.out.println("------------------------------------------------------------");
		}
		
		
		
		for (int i = 0; i < listObjects.size(); i++) {
			String objectPrimary = listObjects.get(i);

			for (int j = 0; j < listObjects.size(); j++) {
				if (listObjects.get(j) != objectPrimary) {
					String objectSecundary = listObjects.get(j);

					for (int k = 0; k < listObjects.size(); k++) {
						if (listObjects.get(k) != objectPrimary && listObjects.get(k) != objectSecundary) {
							String objectTetiary = listObjects.get(k);
							for (int l = 0; l < listObjects.size(); l++) {
								String currentObject = listObjects.get(l);
								if (currentObject != objectPrimary && currentObject != objectSecundary
										&& currentObject != objectTetiary) {
									String quaternaryObject = listObjects.get(l);
								for(int m = 0; m < listObjects.size(); m++) {
									currentObject = listObjects.get(m);
									if(currentObject != objectPrimary && currentObject != objectSecundary && currentObject != objectTetiary && currentObject != quaternaryObject) {
										String quinaryObject = listObjects.get(m);
										for(int n = 0; n < listObjects.size(); n++) {
											currentObject = listObjects.get(n);
											if(currentObject != objectPrimary && currentObject != objectSecundary && currentObject != objectTetiary && currentObject != quaternaryObject && currentObject != quinaryObject) {
												List<String> temporary = new ArrayList<String>();
												temporary.add(objectPrimary);
												temporary.add(objectSecundary);
												temporary.add(objectTetiary);
												temporary.add(quaternaryObject);
												temporary.add(quinaryObject);
												temporary.add(listObjects.get(n));

												boolean insert = false;

												if (sixObjects.isEmpty())
													insert = true;

												for (int o = 0; o < sixObjects.size(); o++) {
													List<String> aux = sixObjects.get(o);
													insert = false;
													for (String element : temporary) {
														if (!aux.contains(element)) {
															insert = true;
															break;
														}

													}
													if (!insert)
														break;
												}

												if (insert)
													sixObjects.add(temporary);
											}
										}
									}
								}
								}
							}

						}
					}
				}
			}

		}
		
		System.out.println("\n\n Seis objetos");
		for (List<String> p : sixObjects) {

			for (String s : p) {
				System.out.println(s);
			}

			System.out.println("------------------------------------------------------------");
		}
		
		
		

	}

	public static Connection getConexao() {
		return conect.getConexao();
	}

}
